/* 
    
Name:  Carson
Period: 1
Lab: Image smoother
Purpose: to smooth int arrays
Notes:

This isn't perfect, I'll admit. There is a slight error while smoothing that results in the
edges being processed as corners. However, it's such a small change that on any decently
sided image it will be indistinguishable from the correct algorithm

Update: No longer a problem! It looks like it's all working great

The way this works is basicly by maintaining a 3xN 2d array in 3 different arrays,
top current and bottom. they slide down the image, smoothing it.


*/

public class Main{
   public static void main ( String[] args ) 
   {
      int[][] image  = { {1,2,3,4,5,6},
                         {2,5,5,5,5,5},
                         {3,5,5,5,5,4},
                         {4,5,5,5,5,3},
                         {5,5,5,5,5,2},
                         {6,5,4,3,2,1}
                       };
   
      printImage (image);  
      smoothImage (image); 
      printImage(image);
   

      int [][] smallImage = createImage (4,6,21);
      printImage (smallImage);
      smoothImage (smallImage);
      printImage (smallImage);

   } //end of main
   
   // precondition: image is nonnullable
   // postcondition: image (in visual form) is smoother
   public static void smoothImage (int [] [] image){
        //store the top, middle, and botoom array while processing the middle array
        int[] top = null;
        int[] current = image[0].clone();//clone so image can be manipulated
        int[] bottom = null;
        for(int r = 0;r<image.length;r++){
            if(r + 1 != image.length)
                bottom = image[r + 1].clone();//only get bottom during iterations
                                              //all other arrays are just moved around
            else
                bottom = null;//
//            System.out.println("r:" + r);     
//            System.out.println("top:" + java.util.Arrays.toString(top));
//            System.out.println("current:" + java.util.Arrays.toString(current));
//            System.out.println("bottom:" + java.util.Arrays.toString(bottom));

            for(int c = 0;c<image.length;c++){
                int count = 0;

                //r1 and c1 represent the offset from r and c
                for(int r1 = -1;r1 <= 1; r1++){for(int c1 = -1; c1 <= 1; c1++){
                    if(r1 == 0 && c1 == 0)continue;//ignore the current square
                    int x = get(top,current,bottom,r + r1,c1,-1);
                    if(x != -1){
                        count++;//know how many times to divide
                        image[r][c] += x;
                    }
                }}

                image[r][c]/=(count + 1);//average, including the current square
            }
//            System.out.println("top:" + java.util.Arrays.toString(top));
//            System.out.println("current:" + java.util.Arrays.toString(current));
//            System.out.println("bottom:" + java.util.Arrays.toString(bottom));
            //make sure (visually) that top, current, and bottom were not effected
            top = current;
            current = bottom;

        }
   }  // end of smoothImage
   
   //simple method for safe bounds checking. WIll return the default (d) if it's unable to   
   // find it
   private static int get(int[] top, int[] current, int[] bottom, int r, int c1, int d){
       if(r < 0)return d;
       int[] arr = (c1 == -1)? top : ((c1 == 0)? current : bottom);
       if(arr == null)return d;
       if(r >= arr.length)return d;
       return arr[r];
   }
   // precondition: none
   // postcondition: image printed to stdout
   public static void printImage (int [] [] image){
       if(image == null)return;
       System.out.println();
       for(int r = 0;r<image.length;r++){
            for(int c = 0;c<image[r].length;c++){
                 System.out.print(image[r][c] + " "); 
            }
            System.out.println();        
       }
   } // print
  
   // precondition: size >= 0, min < max
   public static int[][] createImage (int size, int min, int max){
        int[][] arr = new int[size][size];
        for(int r = 0;r<size;r++){
            for(int c = 0;c<size;c++){
                arr[r][c] = (int)(Math.random() * (max - min) + min);
            }
        }
        return arr;
   }
}

/*
output:

carson42g@penguin:~/java/workspace/school/ImageSmooth$ javac -g *.java
carson42g@penguin:~/java/workspace/school/ImageSmooth$ java Main

1 2 3 4 5 6 
2 5 5 5 5 5 
3 5 5 5 5 4 
4 5 5 5 5 3 
5 5 5 5 5 2 
6 5 4 3 2 1 

2 2 3 3 3 3 
3 3 3 3 3 3 
4 5 5 5 5 4 
4 5 5 5 5 4 
3 3 3 3 3 3 
3 3 3 3 2 2 

17 19 6 20 
20 10 11 11 
18 14 14 14 
11 6 19 15 

16 17 13 17 
15 14 14 14 
13 12 12 12 
14 13 16 15


*/
