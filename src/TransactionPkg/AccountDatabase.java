package TransactionPkg;

public class AccountDatabase {

    private Account[] accounts;
    private int size;

    /**
     * Default constructor for AccountDatabase class
     * Initializes variables to starting values as described below to create an Accounts Database
     */
    public AccountDatabase(){
        this.size = 0;
        this.accounts = new Account[5];
    }

    /**
     *
     * @param account
     * @return int - finds the index at which the account is
     */
    private int find(Account account) {

        int index = -10; // starter value for index
        String profileList = "";
        String curProfile = "";

        for (int i = 0; i < size; i++) {

            curProfile = account.toString();
            profileList = accounts[i].toString();
            String[] inputArry1 = curProfile.split("\\*");
            String[] inputArry2 = profileList.split("\\*");
            System.out.println(inputArry1[1]);
            System.out.println(inputArry2[1]);
            if (inputArry1[2].equals(inputArry2[2])
                    && inputArry1[0].equals(inputArry2[0])
                    && (inputArry1.length == inputArry2.length))
            {
                index = i;
                System.out.println("They match");
                break;
            }
        }

        return index;
    }

    private void grow() {

        int capacity = 0;
        capacity = accounts.length;
        // if the size of the database is 5, increase the capacity by 5
        if (size == accounts.length) {
            Account[] moreAcc = new Account[capacity + 5];
            for (int i = 0; i < size; i++) {
                moreAcc[i] = accounts[i];
            }
            accounts = moreAcc;
        }
    }

    public boolean add(Account account) {
        size++;
        grow();
        // adding an account to the database
        accounts[size-1] = account;

        // just to test if it work
            System.out.println("Account added to the database");
            System.out.println("Capacity: " + accounts.length);
            System.out.println("Size: " + size);

        return false;
    }

    public boolean remove(Account account) {
        boolean removed = false;
        if (size == 0) {
            System.out.println("Database is empty");
            return false;
        }
        int index = find(account);
        if (index != -10) {
            removed = true;
            // swap
            Account temp = accounts[index];
            accounts[index] = accounts[size - 1];
            accounts[size - 1] = temp;

            size--;
            // change last item to null
            accounts[size] = new Checking(null, 0, null, false) {
            };

        }
        return removed;
    }

    public boolean deposit(Account account, double amount) {
        boolean deposit = false;

        if (find(account) >= 0)
        {
           System.out.println("Found account and able to deposit money");
           deposit = true;
        }

        return deposit;
    }

    public int withdrawal(Account account, double amount) {
        return 0;
    }
    //return 0: withdrawal successful, 1: insufficient funds, -1 account doesn’t exist

    private void sortByDateOpen() {
        //sort in ascending order
    }

    private void sortByLastName() {
        //sort in ascending order
    }

    public void printByDateOpen() {
    }

    public void printByLastName() {
    }

    public void printAccounts() {

        if (size == 0)
        {
            System.out.println("Database is empty.");
        }

        else {
            System.out.println("--Listing accounts in the database--");
            for (int i = 0; i < size; i++) {
                System.out.println(accounts[i].toString());
            }
        }
    }

}




