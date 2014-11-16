//Aidan Campbell/Dan Limbacher
//pd.3 5/5/2011

//This program is a terminal game
//to answer yes type 'yes'
//to answer no type 'no'


//New concepts:

//Globalized declarations
//Thread sleeping
//Using quotes, in quotes (Dawg)
//Splitting strings
//Trimming strings


import java.util.*;//SCANNERS, BRO
import java.io.*;//READING FILES, BRO

public class textadventure
{
  //<XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  GLOBAL DECLARATION  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX>
  private static String inventory;//now with 100% more function!

  public static void main(String[] args) throws FileNotFoundException//file is the titlescreen
  {
    int delay=100;
    int s=700;
    int m=1200;
    int l=4000;
    int xl=3000;
    int tdelay=5;
    titlescreen(delay);
    inventory="";//initialization
    Scanner kb=new Scanner(System.in);
    slowout("You awaken in a strange cave, with a splitting headache, wearing a wizard's\nrobe, AND NOTHING ELSE\n\n",5);
    boolean cont = false;
    int turns_survived=0;
    while(!cont)
    {
      int choice = options(kb);
      if(choicebeginning(choice))cont=true;//if they leave, then stop
    }
    //they left the cave (part 2 now)
    turns_survived++;
    cont=false;
    //part 2
    while(!cont)
    {
      if (affirmative(kb))
      {
        if(inventory.indexOf("Pants")!=-1)
        {//they got the pants
          cont=true;
          turns_survived++;
          out("You grab the doorknob with your pants.");
          pause(m);
          out("The pants begin to smoke.");
          pause(l);
          out("Quickly, before the pants incinerate, you twist the doorknob and open the door.");
          pause(xl);
          out("You throw the pants to the ground, and they burn in a black flame.");
          //destroying a pair of pants
          inventory = inventory.substring(inventory.indexOf("Pants")+"Pants".length());
        }
        else
        {//they don't have pants
         out("You grab the doorknob with your bare hand.");
         pause(m);
         out("You realize that when you observed the doorknob was hot, you weren't joking.");
         pause(l);
         out("The heat of the doorknob boils you alive.");
         pause(xl);
         game_over(turns_survived);
        }
      }//they wanted to open the door
      else
      {
        out("You sit there, and starte blankly at the exciting adventure that lies before\nyou.");
        //<XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  USING QUOTES, IN QUOTES (DAWG)  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX>
        out("You lookback upon your life, and ask yourself:\n\"What is more interesting than\n this exciting adventure? Why not open the door?\"");
        out("Do you second guess yourself, and open the door anyways?");
      }
    }
    out("You cautiously open the door.");
    pause(l);
    pause(1000);
    System.out.print(".");
    pause(1000);
    System.out.print(".");
    pause(1000);
    System.out.print(".");
    pause(1000);
    out("You encounter a wild Snorlax!");
 pause(1500);
    Scanner Scat=new Scanner(new File("Snorlax.txt"));
    while(Scat.hasNextLine())
    {
        out(Scat.nextLine());
        pause(1);
    }


    out("\nFun fact:\n A Snorlax's unruly sleeping habits are a result of a lack of music\n");
    if(inventory.indexOf("Pants")!=-1)
      {//they got more pants
        if(!endingoptions(kb))game_over(turns_survived);
        turns_survived++;
        out("You continue on past the Snorlax, and find yourself in an abandoned bedroom.");
        pause(l);
        out("There is a hole in the center of the roof, betraying the light of high-noon.");
        pause(l);
        out("Directly beneath this hole lies a pedastool, a strange gun is resting upon it.");
        pause(l);
        out("For some strange reason, you think this gun makes holes, but not bullet holes.");
        pause(l);
        out("You pick it up, and straddle the gun over your arms.");
        pause(l);
        out("It is a sterile white color, with Magnesium blades at its tip.");
        pause(l);
        out("Throwing caution to the wind, you shoot a wall.");
        pause(l);
        out("The laws of space and time are obliterated, as a hole opens up on the wall.");
        pause(l);
        out("The hole is more of a portal, as you can see people on the other side.");
        boolean q=false;
        pause(l);
        out("Would you like to go through?\n");
        while(!q)
        {
          if(affirmative(kb))q=true;
          else
          {
            out("You stand there, staring at the portal.");
            pause(l);
            out("There may interesting people on the other side.");
            pause(l);
            out("You don't want to come off as anti-social, and the people on the other side\nare staring expectantly at you.");
            pause(l);
            out("Even some lady on the other side asks you \"Would you like to come over?\"\n");
            pause(m);
          }
        }
        //they chose to go through the portal
        pause(m);
        out("\nYou shuffle yourself though the portal, and find yourself in a\nclassroom on the other side");
        pause(l);
        out("You are facing a group of students.  It is a well-lit room\nwith an off-white floor and ceiling.");
        pause(l);
        out("There are three windows to your right, and the number 301 is printed\non a piece of paper, taped to the window.");
        pause(l);
        out("Two totally awesome bros, named Dan and Aidan are presenting something.");
        pause(l);
        out("Your presence has clearly created a disruption in their presentation, so you\nsit at the nearest desk and patiently wait until they are finished.");
        pause(l);
        out("Once finished, they receive vigorous applause due to their space\ntravelling visitor.");
        pause(l);

        Scanner Scar=new Scanner(new File("krauland.txt"));
        while(Scar.hasNextLine())
         {
           out(Scar.nextLine());
           pause(100);
         }


        out("Congradulations! You have successfully completed the game!");
        pause(l);
        out("You lived through all "+ turns_survived+" turns!");
        pause(l);
        System.exit(0);

      //print out various people

      }
      else
      {//no mo pants (only had 1 pair)
      out("You stand there helplessly as the Snorlax goes back to sleep.");
      pause(l);
      out("Unfortunately, this 2 ton beast decided to sleep on top of you.");
      pause(3000);
      game_over(turns_survived);

      }

  }//end of main

  public static boolean endingoptions(Scanner kb)
  {
     out("You dig out your trusty second pair of pants.  What would you like to do\nwith them?\n");
     out("1.) Whip the pants at the Snorlax like nunchucks, to knock it out.");
     out("2.) Play the pants like a flute, to put it to sleep.");
     out("3.) Put the pants onto yourself, and run like a sissy.");
     return ending(kb);
  }

  public static boolean ending(Scanner kb)
  {
    boolean z=true;
    int x=0;
    while(z)
    {
      x=givemenumber(kb.nextLine());
      if((x>0)&&(x<4))z=false;
      else out("Please enter a valid number, 1-3");
    }
    //we have a valid choice now
    if(x==1)
    {
      //hit it with pants
      out("You use your floppy arms to slap the Snorlax with your pants.");
      out("It looks at you kinda funny, then kills you in half.");
      return false;
    }
    if(x==2)
    {
      //put it to sleep, and end it
      //only way to continue
      out("You take the pants, and quickly stretch them out by your head.\nYou play the pants like a flute.");
      pause(3000);
      out("It appears to be working, as the Snorlax is rummaging in his pockets.");
      pause(3000);
      out("It has pulled a bed from its back pocket, and is also pulling out more.");
      pause(3000);
      out("It pulled out a glass of warm milk, and its favorite bedtime story!");
      pause(3000);
      out("Patiently, you read him the story, and the Snorlax drifts off to sleep.");
      pause(3000);
      return true;
    }
    if(x==3)
    {
      //they run like a sissy
      out("You place the pants onto yourself, and proceed to run like a sissy-lala.");
      out("The Snorlax takes a half-hearted swipe at you, and removes your arms");
      out("Armless now, you continue running towards the exit.");
      pause(1500);
      out("But you forgot...");
      pause(1500);
      out("The doorknob...");
      pause(1500);
      out("You violently crash into a half-open door, and crumble into a \nuseless pile after your hip brushes the doorknob");
      pause(3000);
      return false;
    }
    return false;
  }//end of ending()

  public static void game_over(int turns_survived)
  {
    out("You died a gruesome death.");
    if(turns_survived>1)out("You only survived a pitiful "+turns_survived+" turns.");
    else out("I don't know how you did it, but you didn't even survive 2 turns...");
    out("You lose. Game over.");
    System.exit(0);
  }

  public static void titlescreen(int x /*delay by x*/) throws FileNotFoundException
  {
    Scanner Scat=new Scanner(new File("Title.txt"));
    while(Scat.hasNextLine())
    {
        out(Scat.nextLine());
        pause(x);
    }

  }

  public static void pause(int x)
  {
    try
    {
      //<XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  SLEEPING (TIME)  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX>
      Thread.sleep(x);
    }
    catch(Exception e){}//BAD PROGRAMMING, FTW!
  }

  public static boolean choicebeginning(int x)
  {
    if(x==1)
    {
      out("The cave is not too dark; there seems to be light just around a corner to your \nleft. The sides are surrounded by stalagtites, and an infinite stack of pants\nis hanging from one of them.");
      out("Would you like to recover your pants?");
      Scanner kb=new Scanner(System.in);
      if(affirmative(kb))
      {
        inventory +=" Pants";//add pants to inventory
        out("You have obtained: Pants!\n");
      }
      else out("You leave the pants behind, with a strange feeling of losing a loved one...");
    }
    if(x==2)lsinv(inventory);
    if(x==3)
    {
      int l=3000;
      out("You leave the cave.  You find youself facing what seems to be an empty house\nahead.  On either side of it lies a forest.");
      pause(l);
      out("You head towards it, and notice that that it is odd. Some parts appear old,\nwhile others appear new.");
      pause(l);
      out("Cautiously, you continue your approach.  The building is constructed of\ncobblestone, and isn't weathered.");
      pause(l);
      out("The windows are shattered, the drapes are tattered, and the door is battered.");
      pause(l);
      out("As you examine the door, you notice that the area around the doorknob is\nsmoking.");
      pause(l);
      out("The doorknob is hot. Would you like to open the door?");
      pause(l);
      return true;
    }
    else return false;
  }

  public static boolean affirmative(Scanner kb)
  {
    //<XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  TRIMMING  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX>
    String x=kb.nextLine().toLowerCase().trim();
    if((x.equals("yes"))||(x.equals("y"))||(x.equals("sure"))||(x.equals("yeah"))||(x.equals("yeah"))||(x.equals("why not?"))) return true;
    else return false;
  }
  public static void lsinv(String inventory)
  {
    if(inventory!=null)
    {
      //<XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  SPLITTING  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX>
      String inv[]=inventory.split(" ");
      for(int i=0;i<inv.length;i++)out(inv[i]);
    }
    if(inventory=="") out("You have no items.\n");
  }

  public static int options(Scanner kb)
  {
 while(true)
    {
     out("Your possible options are:\n1.)Search\n2.)Inventory\n3.)Leave\n");
  int x= givemenumber(kb.nextLine());
  if((x>=1)&&(x<=3))return(x);
      else out("Invalid choice: please enter a number between 1 and 3");
   }
  }

 public static void slowout(String text, int pause)
 {
  for (int i=0;i<text.length();i++)
  {
   System.out.print(text.charAt(i));
   pause(pause);
  }
 }

  public static int givemenumber(String str)
  {
    boolean y=true;
    try
    {
      int x= Integer.parseInt(str);
      if(y)return x;
    }
    catch(NumberFormatException e)
    {
      if (str.toLowerCase().equals("exit"))System.exit(0);//WORKS!!!
      y=false;
    }
    return 0;//invalid anyways :\
  }//end of givemenumber(from this string)
  
  public static void out(String str)
  {
    System.out.println(str);
  }
}//end of class