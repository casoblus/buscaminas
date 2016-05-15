package buscaminas;
public class Bomba
{
   private boolean activada = false;
   private boolean oculta = true;
   private byte valor = 0;
   private int px,
               py;
   
   public Bomba( int  x, int y )
   {
      this.px = x;
      this.py = y;   
   }
   /**
    * setBomb.
    * @param boolean isMine
    */ 
   public void activar()
   {
      this.activada = true;
      this.valor = -1;
   }
   
   /**
    * icrValue . incrementa el valor de la casilla.
    */
   public void incrementarValor()
   {
      if ( !this.activada )
      this.valor++;
   }
   
   /**
    * isBomb.
    * devuelve si la casilla es una bomba o no.
    */
  
   public boolean bombaActivada()
   {
      return activada;
   }
  
   public void mostrarEstado()
   {
      if ( oculta )
         System.out.print("|XX");
      else
      {
         if ( activada )
            System.out.print("|BB");
         else if ( valor > 0 )
            System.out.print("| " + valor );
         else
            System.out.print("|  ");
      }
   }
   
   public boolean descubrir()
   {
      this.oculta = false;
      return activada;
   }//*/

   public byte obtenerValor()
   {
      return valor;
   }
   
   public void despejar()
   {
      this.oculta = false;
   }


   public void despejar( Bomba[][] tablero )
   {
      if( !this.activada )
      {
         int nx, ny;
         this.oculta = false; // descubre la casilla
         if( this.valor == 0 )
         {
            for( int i = -1; i <= 1; i++ )
            {
               nx = px + i;
               for( int j = -1; j <= 1; j++ )
               {
                  ny = px + j;
                  try 
                  {
                     tablero[nx][ny].despejar(tablero);
                  }
                  catch( Exception e )
                  {
                  }
               }
            }
         }
      }
   }
}
