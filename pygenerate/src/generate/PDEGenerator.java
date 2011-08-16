package generate;

/**
 * (uses jdk 7.0 features)
 * @author Martin Prout after original by Adam Parrish
 * decontextualize.com
 */

public class PDEGenerator extends ContextFree {
    
  public static int MAX_RECURSION = 200; 
  
  public static void main(String[] args) {
    PDEGenerator pdeg = new PDEGenerator();
    pdeg.setMaxRecursion(MAX_RECURSION);
    pdeg.addRule("Drawing", "Square");
    pdeg.addRule("Square", "square", 0.01f);
    pdeg.addRule("Square", "square scale circle");
    pdeg.addRule("Square", "square scale Square");
    pdeg.addRule("Square", "square push left Square pop push right Square pop");
    System.out.println("size(512, 512);\nbackground(255);\nrectMode(CENTER);");
    System.out.println("translate(width/2, height/2);");
    System.out.println("fill(0, 0, 240, 32);\nnoStroke();");
    pdeg.expand("Drawing");
  }
  
  /**
   * Exploring the new switch feature of jdk 7.0 (supports String)
   * @param s String
   */

  public void renderExpansion(String s) {
        switch (s) {
            case "push":
                System.out.println("pushMatrix();");
                break;
            case "pop":
                System.out.println("popMatrix();");
                break;
            case "left":
                System.out.println("translate(-125, 0);");
                System.out.println("scale(0.45);");
                break;
            case "right":
                System.out.println("translate(125, 0);");
                System.out.println("scale(0.45);");
                break;
            case "square":
                System.out.println("rect(0, 0, 500, 500);");
                break;
            case "scale":
                System.out.println("scale(0.75);");
                break;
            case "circle":
                System.out.println("ellipse(0, 0, 500, 500);");
                break;
        }
    
  }

}
