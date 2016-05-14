package buscaminas;
public class Bomba
{
   private boolean activada = false;
   private boolean oculta = true;
   private byte valor = 0;

   /**
    * setBomb.
    * @param boolean isMine
    */ 
   public void activar()
   {
      this.activada = true;
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
   }
}
