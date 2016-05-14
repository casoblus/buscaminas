package buscaminas;
import java.util.*;
public class Helpers
{
   public static Integer getOption()
   {
      Scanner keyb = new Scanner( System.in );
      Integer op;
      try
      {
         op = Integer.parseInt( keyb.nextLine() );
      }
      catch( Exception e )
      {
         op = -10;
      }
      return op;
   }
}
