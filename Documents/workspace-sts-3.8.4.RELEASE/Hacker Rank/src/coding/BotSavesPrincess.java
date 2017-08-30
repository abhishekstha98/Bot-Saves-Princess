package coding;
import java.util.Scanner;

public class BotSavesPrincess {
static void displayPathtoPrincess(int n, String [] grid){
    String []dir=new String[]{"UP","DOWN","LEFT","RIGHT"};
    String s;
    int x = 0,y = 0,x1 = 0,y1 = 0;
    for(int i = 0; i < n; i++) {
    	s=grid[i];
            if(s.contains("p")){
            	x=i;
            	y=s.indexOf("p");
            }
            else{
            	continue;            
            }
            System.out.println(x + "    "+ y);
        }
    for(int i = 0; i < n; i++) {
    	s=grid[i];
            if(s.contains("m")){
            	x1=i;
            	y1=s.indexOf("m");
            }
            else{
            	continue;            
            }
            System.out.println(x1 + "    "+ y1);
        }
    while(true){
    	if(x<x1){
    		--x1;
    		System.out.println(dir[0]);
    	}
    	else if(x>x1){
    		++x1;
    		System.out.println(dir[1]);
    	}
    	else{
    		continue;
    	}
    	if(y<y1)
    	{
    		--y1;
    		System.out.println(dir[2]);
    	}
    	else if(y>y1){
    		++y1;
    		System.out.println(dir[3]);
    	}
    	else{
    		continue;
    	}
    	int m=n;
    	m--;
    	if(m==0){
    		break;
    	}
    }
    return;
  }
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m;
        m = sc.nextInt();
        String grid[] = new String[m];
        for(int i = 0; i < m; i++) {
            grid[i] = sc.next();
        }

    displayPathtoPrincess(m,grid);
    sc.close();
return;    
}
}