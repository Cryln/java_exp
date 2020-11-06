import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu {
    
    public int funSelect(User currentUser){
        int statu = 1; //1 继续，2退出
        Operation op = new Operation(currentUser);

        try (
            FileInputStream fs = new FileInputStream("./DB/menu.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        ) {
            String data = null;
            while((data = br.readLine())!=null){
                System.out.println(data);
            }
            
        } catch (Exception e) {
            e.printStackTrace();//TODO: handle exception
        }
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        String ins = "insert";
        String del = "delete";
        switch(choice){
            case 1:{
                op.changePasswd();
                break;
            }
            case 2:{
                op.printCources(op.getCources());
                break;
            }
            case 3:{
                op.findStuByCource(op.getStuByCource());
                break;
            }
            case 4:{
                op.insertCource();
                break;
            }
            case 50:{
                op.stuListOp(ins);
                break;
            }
            case 51:{op.stuListOp(del);
                break;
            }
            case 60:{op.tchListOp(ins);
                break;
            }
            case 61:{op.tchListOp(del);
                break;
            }
            case 70:{op.crsListOp(ins);
                break;
            }
            case 71:{op.crsListOp(del);
                break;
            }
            case 80:{op.seleListOp(ins);
                break;
            }
            case 81:{op.seleListOp(del);
                break;
            }
            case 90:{op.tchListOp(ins);
                break;
            }
            case 91:{op.tchListOp(del);
                break;
            }
            case 10:{op.resetUser();
                break;
            }
            case 0:statu=2;break;
            default:{
                statu =1;
            }
        }
        return statu;
    }
    
}
