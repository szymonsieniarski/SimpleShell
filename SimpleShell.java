//SimpleShell.java

/**
Simple Java Shell, which able to producee i executee own commands

Prosta powłoka Java

**/




import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

class BasicShell 
    {
	BasicShell(){
	   System.out.print(BasicShell.znak);}// konstruktor
	
	//pole dost_polcenie przechowuje nazwy poleceń
	static String[] dost_polecenia = {"brak polecenia aby wyświetlić dostępne komendy wpisz \"polecenia\" ","polecenia","romb", "wlasciwosci", "wyjscie"};
	static String znak="simple jsh>"; //pole przechowuje znak zachęty (ułatwia to zmianę) 
	
	
	int wybor(String polecenie){ //metoda zwraca numer polecenia

		int n=dost_polecenia.length;
		int i,k=0;
		boolean jest_polecenie;
	
		for (i=0;i<n;i++)
		{ if (polecenie.equals(dost_polecenia[i])) {jest_polecenie=true;k=i;} }

		return k;}
		
	static void Znaki(int spa, String cha) //funkcja wypisuj zadaną liczbę danego znaku
	
		{for (int j = 0; j < spa; j++) 
        		System.out.print(cha);
     			 }
 	public void polecenia(){ //wyświetlane są wszystkie dostępne polecenia
 		System.out.println("Dostępne polecenia: ");
 		for (int i=1; i<dost_polecenia.length;i++)System.out.println(dost_polecenia[i]);
 			}
 			
 			
 	public void romb(int a) //metoda rysuje romb  
 		{ int l;
    
    		int[] tablica=new int[a+1];   //tworzymy tablicę liczb nieparzystych do sterowania *
			for (int i=0; i<=a; i++)tablica[i]=(i*2+1);
			System.out.println();
			//rysujemy góre rombu
		for (int i=0; i<=a; i++) 
			
			   {
			    l=a-i;		
			    Znaki(l," ");
			    Znaki(1,"*");
			     if (i > 0)	
				    {
				     Znaki(tablica[i]-2," ");
				     Znaki(1,"*");
				    }
			    System.out.println();
			  }
			
			for (int i=a-1; i>=0; i--) 
			
			   {
			    l=a-i;		
			    Znaki(l," ");
			    Znaki(1,"*");
			     if (i > 0)	
				    {
				     Znaki(tablica[i]-2," ");
				     Znaki(1,"*");
				    }
			    System.out.println();
			  }
			
			}
 	public String wlasciwosci() 
	{
	Properties system_properties = System.getProperties();
		if(system_properties != null) 
		{
			Set<String> properties_names = system_properties.stringPropertyNames();
			if(properties_names != null) 
			{
				System.out.println("Lista wlasciwosci systemowych:");
				Iterator<String> iterator = properties_names.iterator();
				for(;iterator.hasNext();) 
				{
					String propertie_name = iterator.next();
					System.out.println(propertie_name + "\t:\t" + system_properties.getProperty(propertie_name));
				}
			} else 
			{
				System.out.println("Nie mozna pobrac nazw wlasciwosci systemowych.");
			}
		} 
		else {
			System.out.println("Nie mozna pobrac wlasciwosci systemowych.");}
			return"";
	}
 	
 	
 	
 	

    } //koniec klasy BasicShell
	
class Baza extends BasicShell 
 { 
       //metody
      public void wywol(int num, String param[]) { //wywoływanie polecenia
        int a;
        switch(num)
           {
		case 0:
		 System.out.println("nieznane polecenie, wpisz \"polecenia\" aby zobaczyć dostępne komendy");
		 break;
		case 1: 
		 super.polecenia();
		 break;
		case 2: //wywołujemy metodę romb jednocześnie sprawdzając czy argument da się przekszatłcić na int
		   
		 {try {a=Integer.parseInt(param[1]);} 
		 catch (NumberFormatException e) {System.out.println("romb argument nie jest typu int"); break;}
		 catch (ArrayIndexOutOfBoundsException e) {System.out.println("romb, brak parametru ");break;};}
		 super.romb(a);
		 break;
		case 3:
		 System.out.println(super.wlasciwosci()); 
		case 4:
		  System.out.println("bye.....");
		  System.exit(0);
		 default:
		 break;
            }
         }
     
     
      }	//koniec klasy BasicShell



	public class SimpleShell

	{
	 public static void main(String[] args) throws java.io.IOException {

	
	  String userLn; //łańcuch tekstowy userLn przechowuje wprowadzoną przez użytkownika Linię

	  BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

	
	while (true) { //petla główna

	  // wywołujemy znak zachęty powłoki, który jest wypisywany pzez domyślny konstruktor BasicShell
	  BasicShell c1= new BasicShell();
	
	  userLn = console.readLine();
		//pusty enter - powtarzamy pętle nic nie przetwarzamy
		if (userLn.equals(""))continue;

			else{
			String[] commands = userLn.split(" "); //dzielimy userLn na oddzielne łańcuchy znaków po " " wpisywane za pomocą metody 
			List<String> list = new ArrayList<String>();
			
			
			//wpisywana do ArrayList list
			for(int i = 0;i<commands.length;i++){
				list.add(commands[i]);}
				
				
				System.out.println("użytkownik wprowadził nastepujące polecenie: "+list.get(0));
				if (list.size()>1){
				System.out.println("z następującymi argumentami:");
				for(int i = 1;i<list.size();i++)
				System.out.println("argument["+i+"]: "+list.get(i));};
				Baza b1=new Baza();//konstruktor klasy Baza metoda wywol odpowiada za wybranie polecenia
				b1.wywol(c1.wybor(commands[0]),commands);
				//System.out.println("wybrano polecenie nr"+c1.wybor(commands[0]));
				
			  }	
				
				
		
				
	 

	 

	  } //koniec petli głównej
	 }//koniec metody main

	}//koniec klasy SimpleShell
