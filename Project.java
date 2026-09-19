import java.util.Scanner;
class Project{
    static Scanner in = new Scanner(System.in);
    static int findIndex(int arr[],int t){
        if(arr==null)
            return -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==t)
                return i;
        }
        return -1;
    }
    static String inputs(String prompt){
        System.out.print(prompt);
        String a = in.nextLine();
        return a;
    }
    static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    static int inputi(String prompt){
        System.out.print(prompt);
        int a = in.nextInt();
        in.nextLine();
        return a;
    }
    public static void main(String[] args){
        clearScreen();
        int n = inputi("How many candidates are there ? ");
        String [] can_list = new String[n];
        int [] votes = new int[n];
        clearScreen(); 
        for(int i=0;i<n;i++){
            System.out.printf("Enter Candidate %d :",i+1);
            can_list[i] = inputs(" ");
            clearScreen();
        }
        while(true){
            char svote = inputs("Start voteing (Y/N) : ").charAt(0);
            clearScreen();
            if(svote == 'Y'){
                break;
            }
       }
       while(true){
            for(int i=0;i<n;i++){
                System.out.printf("Candidate %d %s\n",i+1,can_list[i]);
            }
            int vote = inputi("Enter your canditate number : ")-1;
            clearScreen();
            if(vote<0){
                break;
            }
            votes[vote]++;
        }
        for(int i=0;i<n;i++){
            System.out.printf("%s %d \n",can_list[i],votes[i]);
        }
        int c=0;
        for(int i=0;i<n-1;i++){
            int a = votes[i];
            int b = votes[i+1];
            if(a>b && a>c){
                c=a;
            }
            else if(b>c){
                c=b;
            }
        }
        String winner = can_list[findIndex(votes, c)];
        System.out.print(winner+" has won the election!!!!");
    }
}