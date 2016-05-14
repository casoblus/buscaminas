package buscaminas;
import java.util.*;
import java.io.*;
public class Juego
{  
   private byte X, 
                Y; 
   int nBombas;

   private Bomba[][] tablero;

   public Juego()
   {
      this.nuevoJuego();
   }



   public Integer elegirDificultad()
   {
      Helpers helper = new Helpers();
      Integer dificultad;
      do {
         System.out.println("\n");
         System.out.println( "1. Fácil." );
         System.out.println( "2. Normal." );
         System.out.println( "3. Difícil." );
         System.out.print( "\n Elige dificultad: " );
         dificultad = helper.getOption();
      } while ( dificultad < 1 || dificultad > 3 );
      return dificultad;
   }
   
   
   
   public void nuevoJuego()
   {
      Integer dificultad = elegirDificultad();
      switch( dificultad )
      {
         case 1:
            X = 20;
            Y = 20;
            nBombas = 10;
            break;
         case 2:
            X = 20;
            Y = 20;
            nBombas = 40;
            break;
         case 3:
            X = 20;
            Y = 20;
            nBombas = 120;
            break;
      }
      tablero = new Bomba[X][Y];

      for ( int xi = 0; xi < X; xi++ )
      {
         for ( int yi = 0; yi < Y; yi++ )
         {
            tablero[xi][yi] = new Bomba();
         }
      }

      activarBombas();
   }
   
   
   
   private void activarBombas()
   {
      Random rnd = new Random();
      byte bx,
           by;
      for ( int n = 0; n < nBombas; n++ )
      {  
         
         do 
         {
            // generar i aleatorio entre 0 y X
            bx = (byte)rnd.nextInt(X);
            // generar j aleatorio entre 0 e Y
            by = (byte)rnd.nextInt(Y);
         } 
         while ( tablero[bx][by].bombaActivada() );
         
         // Activar bomba en posicion i,j
         tablero[bx][by].activar();
         
         // incrementar valor de las casillas alrededor
         for ( int i = -1; i <= 1; i++ )
         {
            for ( int j = -1; j <=1; j++ )
            {
               try
               {
                  tablero[ bx+i ][ by+j ].incrementarValor(); 
               }
               catch(Exception e )
               {
                  continue;
               }
            }
         }

      }
   }


   
   public void jugar()
   {
      int descubiertas = 0;
      Integer fila, columna;
      boolean bomba = false;
      mostrarTablero();
      Helpers sel = new Helpers();
      do {
         do {
            System.out.print("\n ");
            System.out.print("Seleccionar fila: ");
            fila = sel.getOption();
         } while ( fila < 0 || fila > Y );
         do {
            System.out.print("\n ");
            System.out.print("Seleccionar columna: ");
            columna = sel.getOption();
         } while ( columna < 0 || columna > X );
            
         bomba = tablero[fila][columna].descubrir();
         descubiertas++;
         mostrarTablero();
      } while ( descubiertas < 400-nBombas && !bomba );
   }
 
 
   public void mostrarTablero()
   {
      System.out.print("| 0| 1| 2| 3| 4| 5| 6| 7| 8| 9|10|11|12|13|14|15|16|17|18|19|" );
      for ( int i = 0; i < X; i++ )
      {
         System.out.print("\n" );
         for ( int j = 0; j < Y; j++ )
         {
            tablero[i][j].mostrarEstado();
         }
         System.out.print("|" + i);
      }
      System.out.print("\n");
   }
 //  public Juego(){}
 //  public Juego(){}
}
