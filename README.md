# Proyecto No.2 -Programación Avanzada-
Metodo Lectura de Arvhivos
-----------------------------
+ Para la realización del siguiente proyecto fue necesario leer archivos de tipo txt, los cuales tendrian un formato predeterminado; para la lectura de los archivos se implemento el siguiente método...
~~~
 public String AbrirArchivo (File archivo){
                documento = "";
        try {
            entrada = new FileInputStream(archivo);
            int i;
            while ((i=entrada.read()) != -1){
                char caracter = (char) i;
                documento += caracter;
            }
        }catch (Exception e){ 
        }
        return documento;
        }
~~~

Metodo PalabraPorLinea 
----------------------------
+ El siguiente metodo se encarga de obtener la palabra que indica el tipo de estructura que desea implementar, obtine los caracteres del inicio del documento hasta el salto de linea almacenandolos en una variable de tipo string
~~~
 private String PalabraPorLinea(String caracter, int pos1){
        int i =0;
            while(caracter.charAt(i)!= '\r'){
                if(caracter.charAt(i)!= ' '&& i<caracter.length()){
                     word+= caracter.charAt(i);
                     i++;
                }
            }
        return word;
        
    }
~~~

Metodo NumeroPosicion
-------------------------
+ Este metodo se encarga de recorer las pociciones iniciadas en un punto hasta encontrar el salto de linea, y retorna el numero de posicion donde se encuentra el salto de linea.
~~~

 ~~~
 Metodo CrearStack
 -----------------------------
 

