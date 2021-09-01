/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicattion_exam;
import java.util.ArrayList;


/**
 *
 * @author jdt28
 */
public class APLICATTION_EXAM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //data para ARE_SAME
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
	int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        boolean expResult = false;
        boolean result = ARE_SAME(a, b);
        //    ult,result);
 
        
        //data para diff
        diff(new int [] {1,2}, new int[] {1});
	diff(new int [] {1,2,2}, new int[] {1});
	diff(new int [] {1,2,2}, new int[] {2});
	diff(new int [] {1,2,2}, new int[] {});
	diff(new int [] {}, new int[] {1,2});
	diff(new int [] {5,2}, new int[] {});
	diff(new int [] {9,4,2,23,5,52,83,22}, new int[] {83,24,23,5});

        //data findmissingletter
        findMissingLetter(new char[] { 'a','b','c','d','f' });
         findMissingLetter(new char[] { 'k','l','n','o' });
	findMissingLetter(new char[] { 'u','v','x' });
        findMissingLetter(new char[] { 'O','Q','R','S' });
        findMissingLetter(new char[] { 'X','Z' });
        
        //data Persistence
        persistence(39);
        persistence(4);
	persistence(999);	
	persistence(10);
	persistence(25);
	persistence(39);
	persistence(77);
	persistence(679);
	persistence(6788);
	persistence(68889);
	persistence(2677889);
	persistence(26888999);
	persistence(3778888999l);
        
        
        
        //Data ValidatePin
        //validPins
                  isValid("1234");
                  isValid("0000");
                  isValid("1111");
                  isValid("098765");
                  isValid("000000");
                  isValid("090909");

	//nonDigitCharacters
		 isValid("123a");
		 isValid("987.");
		 isValid("4521((");
		 isValid("..1234#!");

	//invalid pins
		 isValid("0");
		 isValid("98");
		 isValid("123");
		 isValid("98745");
		 isValid("9876543");
		 isValid("-4567");
		 isValid("1.241");
		 isValid("00000000");
		 isValid("12 34");
		 isValid("0");
		 isValid(" 1234 ");
		 isValid("98  76");
		 isValid(" 1111");
        
        
        
        
        
        
    }
    

/**
 * comp checks whether the two arrays have the "same" elements, with the same multiplicities. "Same" means, 
 * here, that the elements in b are the elements in a squared, regardless of the order.
 * 
 * @author developer
 */    
public  static boolean  ARE_SAME(int []a, int [] b){
    
    //variable temporal donde se almacena el resultado de la multiplicación de los elementos recorridos del arreglo (a)
    int temp=0;
    //variable que validará que todos los elementos de (A) tengan su multiplo en (B)
    int VALIDADOR=0;
    
    //validamos si ambos arreglos no vienen vacios
    if (a != null && b!=null){
        
        //validamos que tengan el mismo tamaño los arreglos
            if (a.length==b.length){
                    //recorremos el arreglo (A) para ver el número que tiene cada posición, hacer el calculo correspondiente
                    //y buscar el resultado dentro del arreglo B
                    for(int i=0 ; i<=a.length-1; i++){
                       //guardamos la multiplicación en la variable temp   
                       temp=a[i]*a[i];   
                            //recorremos el arreglo B para verificar si el resultado existe           
                            for(int x=0 ; x<=b.length-1; x++){
                                   //validamos si el elemento actual del arreglo b es igual al resultado de la multiplicación del elemento (a) por si mismo   
                                    if (temp==b[x]){
                                        //igualamos a 0 el elemento para notificar que este elemento ya tiene su multiplo en (A)
                                        b[x]=0;
                                        VALIDADOR++; 
                                    }
                            } 
               

                    }
                               //SI EL VALIDADOR ES IGUAL AL TAMAÑO DEL ARREGLO DE (A) quiere decir que todos los datos fueron verificados y encontrados con sus multiplos
                            if (VALIDADOR==a.length){
                            System.out.println("SUCCESS");
                            return true;
                            }else{
                            System.out.println("ERROR");
                            return false;
                            }
            }else{
             System.out.println("La cantidad de números en los arreglos no coinciden");
            }        
                
                
    }else{    
    System.out.println("Uno de los 2 arreglos estan vacios");
    }            
            
    return true;
         
	}



/**
 * diff subtracts one list from another and returns the result.
 * It should remove all values from list a, which are present in list b keeping their order.
 * 
 * @author developer
 */
public static int[] diff(int[] a, int[] b) {
	
//arreglo que se retornará 
int [] ARREGLO_TEMPORAL = new int [a.length];
//declaramos una variable que nos dira cuantos elementos se eliminaron
int numeros_eliminados=0;


//si el arreglo de B esta vacio, retornamos el array A
if (b.length==0){
return a;
}

//si el arreglo de a esta vacio, retornamos el array A
if (a.length==0){
return a;
}


    //validamos si ambos arreglos no vienen vacios
    if (a != null && b!=null){
        //creamos el indice para el arreglo que se retornará
        int IND=0;
        //creamos una variable temporal
        int temp=0;
        //creamos una variable que nos dira si el elemento existe
        boolean validador= false;
        
                    //recorremos el arreglo (A) para ver el número que tiene cada posición
                    //y buscar el valor dentro del arreglo B
                    for(int i=0 ; i<=a.length-1; i++){

                            //recorremos el arreglo B para verificar si el resultado existe           
                            for(int x=0 ; x<=b.length-1; x++){
                                   //validamos si el elemento actual del arreglo b es igual al elemento buscado de (A)
                                  if (a[i]==b[x]){ 
                                   //el validador se activa, los elementos coinciden
                                   validador=true;
                                   numeros_eliminados++;
                                   break;
                                  }
                                  //validamos si es el ultimo elemento en registrar y el validador se quedo en false
                                  //se registra el nuevo numero
                                  if (x==b.length-1 && validador==false){
                                      //guardamos el número a guardar en la variable
                                   int elemento_guardar=a[i];   
                                   //System.out.println("DATO A GUARDAR -> "+elemento_guardar+"\n");
                                   //guardamos el numero en el arreglo
                                    ARREGLO_TEMPORAL[IND]=elemento_guardar; 
                                    IND++;
                                  }
                                  
                            } 
                            validador=false;
                    }
                    
//ARREGLO_RETORNO LIMPIAMOS EL ARRAY
//declaramos el arreglo que se retornará con el tamaño exacto de los elementos en el arreglo temporal
int [] ARREGLO_RETORNO = new int [ARREGLO_TEMPORAL.length-numeros_eliminados];
                    for (int s=0; s<ARREGLO_TEMPORAL.length-1; s++){
                       //verificamos que el campo no este en 0 y asi agregamos un elemento nuevo a el array que se retornará
                        if (ARREGLO_TEMPORAL[s]!=0){                        
                           ARREGLO_RETORNO[s]=ARREGLO_TEMPORAL[s];
                           //System.out.println(ARREGLO_TEMPORAL[s]+"\n");
                       }
                    }
                    
                   return ARREGLO_RETORNO;
                    
    }else{    
    System.out.println("Uno de los 2 arreglos estan vacios");
     return ARREGLO_TEMPORAL;
    }            
            
   
        
}





/**
 * findMissingLetter takes an array of consecutive (increasing) letters as input and that returns the missing letter 
 * in the array. You will always get an valid array. And it will be always exactly one letter be missing. 
 * The length of the array will always be at least 2.The array will always contain letters in only one case.
 * (Use the English alphabet with 26 letters)
 * 
 * @author developer
 */
public static char findMissingLetter(char[] letters) {
                //declaramos el arreglo del abecedario
                 char[] array_letters = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};            

                 //declaramos una variable donde se guarda la posicion de la primera letra y de la ultima
                int primera_posicion=0;
                int ultima_posicion=0;
                //declaramos la variable donde se guardará la letra faltante
                char letra_faltante=' ';
                //declaramos el tamaño del arreglo enviado
                int numero_letras=letters.length+1;
                
                //obtenemos el valor de la primera y ultima letra 
                 char primera_letra = Character.toLowerCase(letters[0]);
                 char ultima_letra = Character.toLowerCase(letters[letters.length-1]);


                 //recorremos el arreglo del abecedario para obtener las posiciones de la primera y segunda letra y asi hacer una lista de las letras que se encuentran 
                 //dentro de ese rango
                 for (int i=0; i<array_letters.length; i++){

                     //guardamos la primera posicion
                     if (array_letters[i]==primera_letra){
                      primera_posicion=i;
                     }
                     //guardamos la segunda posicion
                     if (array_letters[i]==ultima_letra){
                      ultima_posicion=i;
                     }     


                 }

                 //declaramos un contador de letras el cual nos indicará en que posicion nos encontramos checando las letras
                 int contador_seleccion_letras=0;
                 //recorremos el arreglo del abecedario desde la primera posicion que guardamos hasta la ultima
                 for (int x=primera_posicion; x<array_letters.length; x++){

                                //validamos  que estemos dentro del rango 
                               if (x<=ultima_posicion){  

                                   //validamos si la letra en la posicion X es igual a la letra en la posicion del contador
                                   if (array_letters[x]==Character.toLowerCase(letters[contador_seleccion_letras])){

                            //System.out.println("letra encontrada: "+array_letters[x]);
                                  contador_seleccion_letras++;
                                   }else{    
                                               //en caso de que la letra faltante aparezca, se almacena en una variable que retornará la letra faltante 
                                               System.out.println("letra faltante :"+array_letters[x]);
                                               letra_faltante=array_letters[x];

                                   }

                             }
                 }

                            return letra_faltante;
}


        /**
 * persistence takes in a positive parameter num and returns its multiplicative persistence, which is the number 
 * of times you must multiply the digits in num until you reach a single digit.
 * 
 * @author developer
 */
public static int persistence(long num) {
 
                //creamos una variable donde se almacenara el resultado         
                int result = 0;
                
                //validamos que el número ingresado sea mayor a 9 para poder proceder a las multiplicaciones
                //en caso de que sea menor , se retorna el 0
                while (num > 9) {
                    
                    //declaramos la variable donde se almacenará la multiplicación
                    long multiplicacion = 1;
                    
                    //convertimos el numero en un string
                    String string_numeros = String.valueOf (num);
                    //convertirmos el string en un arreglo char 
                    char [] Numeros_divididos = string_numeros.toCharArray();
                                    
                                       //recorremos el array char y multiplicamos por cada numero dentro del arreglo char
                                     for (char x :Numeros_divididos) {
                                            //convertimos el valor del numero de string a long y asignamos los valores resultantes a la variable multiplicacion
                                             multiplicacion *= Long.parseLong(String.valueOf(x));
                                            //System.out.println("RESULTADO-MULTI:"+multiplicacion);

                                     }
                    //guardamos el resultado de las multiplicaciones en num nuevamente y si es necesario, se repite el proceso
                    num = multiplicacion;
                    //guardamos cuantas veces se realizo el proceso   
                    result++;
                             }
                
                             System.out.println("VECES MULTIPLICADA:"+result);
                             return result;


            
}

/**
 * isValid allow 4 or 6 digit PIN codes and PIN codes cannot contain anything but exactly 4 digits or exactly 6 digits.
 * If the function is passed a valid PIN string, return true, else return false.
 * 
 * @author developer
 */
public static boolean isValid(String pin) {
//convertimos el string en array 
char[] String_array =pin.toCharArray();
             
            //verificamos si el string cumple con el tamaño de 4 o 6 elementos
            if (String_array.length==4 || String_array.length==6){ 
            
            //recorremos el array char para verificar los datos de cada uno    
            for (char valor: String_array ){
                //verificamos si el valor es un numero , si no lo es retornamos false
                if (!Character.isDigit(valor)){
                 System.out.print("Este Caracter en este Pin no es valido: "+ valor+"\n"); 
                 return false;   
                }   
            }    
                
                
              System.out.print("Pin correcto \n"); 
                return true;
            }else{

                System.out.print("La longitud del String no es valida \n"); 
                return false;



            }




}






} 
    
    
    
   