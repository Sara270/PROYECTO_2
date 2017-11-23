# Proyecto No.2 -Programación Avanzada-
Metodo Lectura de Archivos
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
 private int numeroPosicion(int ultimaLinea){
        for (int i =ultimaLinea; i<documento.length();i++){
            if(documento.charAt(i)== '\n'){
                pos=i;
                  break; 
                }
            }
        return pos;
        }
 ~~~
 Metodo CrearStack
 -----------------------------
 + Este metodo crea un stack utilizando los valores desde la posicion ingresada hasta el salto de linea 
 ~~~
   public int crearStack(int posicion){
            String caracter= txtarea.getText();
            int i=0;
            for( i=posicion;i<caracter.length();i++){
               if ((caracter.charAt(i) != '\r') && (caracter.charAt(i)!= ' ') ){
                         Stack.push(caracter.charAt(i));
                         } else if ((caracter.charAt(i) == '\r')){
                          break;   
                  }
               
               
            }
        JOptionPane.showMessageDialog(null, "Stack Creado"); 
        return i;
        }
 ~~~
 
Metodo CrearQueue
--------------------------
+ Este metodo crea un queue utilizando los valores desde la posicion ingresada hasta el salto de linea
~~~
      public int crearQueue(int posicion){
            String caracter= txtarea.getText();
           int i=0;
      
          for( i=posicion;i<caracter.length();i++){
              if ((caracter.charAt(i) != '\r') && (caracter.charAt(i)!= ' ') ){ // verifica que no guarde espacios ni saltos de linea
                         queue.enqueue(caracter.charAt(i));
                         } else if ((caracter.charAt(i) == '\r')){
                          break;   
             }
          }
               JOptionPane.showMessageDialog(null, "queue Creado"); 
                return i;
        }
~~~

Metodo CrearLinkedList
-----------------------
+ Este metodo crea una Lista enlazada utilizando los valores desde la posición ingresada hasta el salto de linea
~~~
 public int crearLinkedList(int posicion){
               String caracter= txtarea.getText();
            int i=0;
            for( i=posicion;i<caracter.length();i++){
               if ((caracter.charAt(i) != '\r') && (caracter.charAt(i)!= ' ') ){
                         LinkList.addLast(caracter.charAt(i));
                         } else if ((caracter.charAt(i) == '\r')){
                          break;   
                  }
            }
               
         JOptionPane.showMessageDialog(null, "LinkedList Creado"); 
                return i;
            
        }
~~~

Metodo CrearDoubleLinkedList
----------------------------
+ Este metodo crea una Lista doblemente enlazada utilizando los valores desde la posición ingresada hasta el salto de linea
~~~
public int crearDoubleLinkedList(int posicion){
               String caracter= txtarea.getText();
            int i=0;
            for( i=posicion;i<caracter.length();i++){
               if ((caracter.charAt(i) != '\r') && (caracter.charAt(i)!= ' ') ){
                         DLinkList.addLast(caracter.charAt(i));
                         } else if ((caracter.charAt(i) == '\r')){
                          break;   
                  }
               
           }
               
         JOptionPane.showMessageDialog(null, "DoubleLinkedList Creado"); 
                return i;
        }
~~~

Metodo CrearCircularLinkedList
------------------------------
+ Este metodo crea una Lista enlazada circular utilizando los valores desde la posición ingresada hasta el salto de linea
~~~
 public int crearCircularLinkedList(int posicion){
               String caracter= txtarea.getText();
            int i=0;
            for( i=posicion;i<caracter.length();i++){
               if ((caracter.charAt(i) != '\r') && (caracter.charAt(i)!= ' ') ){
                         CLinkList.addLast(caracter.charAt(i));
                         } else if ((caracter.charAt(i) == '\r')){
                          break;   
                  }
               }
               
         JOptionPane.showMessageDialog(null, "CircularLinkedList Creado"); 
                return i;
        }
~~~ 

Metodo Comparar
---------------
+ En este metodo se recibe como parametro un string que contiene el nombre de la estructura de datos y luego compara este nombre con el predefinido de las estructuras con el objetivo de retornar un valor numerico dependiendo de la estructura
~~~
 public int Comparar(String estructura){
        int n;  

          String c;
         c = estructura;
          
           if (" stack".equals(c)){
                n=1;
           }else if (" queue".equals(c)){
                n=2;
           }else if (" linkedlist".equals(c)){
                n=3;
           }else if(" circularlinkedlist".equals(c)){
                n=4;
           }else if(" doublelinkedlist".equals(c)){
                n=5;
           }else if (" btree".equals(c)){
               n=6;
           }else{
               n=7;
           }
           return n;
     }
~~~

Metodo CrearEstructura
----------------------
+ Este metodo contiene un swich que dependiendo el numero obtenido del metodo comparar, crea una estructura de datos
~~~
public int CrearEstructura(int opcion, int posicion){
          // este metodo tras obtener un numero del metodo comparar y crea la estructura depepndiendo del numero
            int nposFinal=0;
                     switch (opcion){
                case 1: nposFinal=crearStack(posicion);
                    break;
                case 2: nposFinal= crearQueue(posicion);
                    break;
                case 3:nposFinal= crearLinkedList(posicion);
                    break;
                case 4: nposFinal= crearCircularLinkedList(posicion);  
                    break;
                case 5: nposFinal=crearDoubleLinkedList(posicion);               
                    break;
                case 6: nposFinal=crearBtree(posicion);
                    break;
                default: JOptionPane.showMessageDialog(null, "Estructura Invalida");             
            }  
                     return nposFinal;
    }
~~~

Metodo Funcional
----------------
+ Este ejecuta de forma ordenada los otros metodos para obtener la estrutura gráfica
~~~
 public void funcional(){
        // Llama  los metodos en orden para que los metodos se ejecuten en un ciclo
        int var;
        int npos;
        while(pos< documento.length()){
           String estructura= PalabraPorLinea(documento,pos);
           var = Comparar(estructura);
           npos = numeroPosicion(pos);
           npos += 1;
           npos=(CrearEstructura(var,npos)+2);
           pos=npos;
        }
    }  
~~~

Metodo para Imprimir Las Estructuras
------------------------------------
~~~
private void PruebaActionPerformed(java.awt.event.ActionEvent evt) {                                       
       
            while(Stack.isEmpty()!=true){
            textAStack.append(Stack.pop().toString() + "\n");
            }
    }      
 private void MostrarQueueActionPerformed(java.awt.event.ActionEvent evt) {                                             
        while(queue.isEmpty()!=true){  
            textAQueue.append(queue.dequeue().toString() + " ");
            }
    }                                            
 
private void LinkedListMActionPerformed(java.awt.event.ActionEvent evt) {                                            
        while(LinkList.isEmpty() != true){
            if(LinkList.size()==1){ // condicion que indica que el ultimo elemento en la lista se imprimira sin una flecha
                 textALinkList.append(LinkList.removeFirst().toString());
            }
            textALinkList.append(LinkList.removeFirst().toString() + " -> ");
        }
    }                                           
   
private void MDoubleLinkedListActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        while(DLinkList.isEmpty()!=true){
            if(DLinkList.size()==1){
                textADoubleLinkList.append(DLinkList.removeFirst().toString()); 
            }
            textADoubleLinkList.append(DLinkList.removeFirst().toString() + " <-> ");
            
            }
    }                                                 
 
    private void MCircularLinkedListActionPerformed(java.awt.event.ActionEvent evt) {                                                    
       int t=0;
       
        while (CLinkList.isEmpty()!= true){
            
            textACircularLinkedList.append(CLinkList.removeFirst().toString() + " -> ");
            t++; 
           }
        impresion(t);
    }                                                   
     public void impresion(int t){
         // Imprime las flechitas de la lista circular
         textACircularLinkedList.append("\n");
         textACircularLinkedList.append("^-");
         for (int i= 0; i<t; i++){
          textACircularLinkedList.append("-----");
         }
         textACircularLinkedList.append("-v");

     }

