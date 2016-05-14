package buscaminas;

public class Buscaminas
{  
   
   private static void mainMenu()
   {  
      System.out.println();
      System.out.println();
      System.out.println(" BUSCAMINAS ");
      System.out.println();
      System.out.println("1. Juego nuevo. ");
      System.out.println("2. Créditos. ");
      System.out.println("0. Salir. ");
      System.out.println();
      System.out.print("Elije una opcion válida: ");
   }

   private static void credits()
   {
      System.out.println("Carlos Alberto Sobrino");
   }

   public static void main( String[] args )
   {  
      Helpers helper = new Helpers();
      int op;
      do {
         mainMenu();
         op = (int)helper.getOption();
         System.out.println(op);

         switch( op )
         {
            case 1:
               System.out.println(op);
               Juego juego = new Juego();
              // juego.nuevoJuego();
                juego.jugar();
               break;
            case 2:
               credits();
               break;
            case 0:
               break;
            default:
               System.out.println("Opción incorrecta.");
         }
      } while ( op != 0 );
   }
}
