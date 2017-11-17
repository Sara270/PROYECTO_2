# Proyecto No.2 -Programación Avanzada-
Para la realización del siguiente proyecto fue necesario leer archivos de tipo txt, los cuales tendrian un formato predeterminado; para la lectura de los archivos se implemento el siguiente método...
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

