package generate;

 /**
 * (uses jdk 7.0 features)
 * @author Martin Prout after PDE generator by Adam Parrish
 * decontextualize.com
 */

public class PYGenerator extends ContextFree {

  public static void main(String[] args) {
    PYGenerator pdeg = new PYGenerator();
    pdeg.addRule("Drawing", "Square");
    pdeg.addRule("Square", "square");
    //pdeg.addRule("Triangle", "triangle");
    pdeg.addRule("Square", "Triangle");
    pdeg.addRule("Triangle", "Square Triangle");
    pdeg.addRule("Square", "square scale circle rotate Square square");
    pdeg.addRule("Triangle", "square scale circle rotate triangle triangle");
    pdeg.addRule("Triangle", "square scale triangle scale triangle");
    pdeg.addRule("Square", "square scale Square");
    pdeg.addRule("Square", "square push left Square pop push right Square pop");
    pdeg.addRule("Square", "square scale circle rotate square");
    pdeg.addRule("Triangle", "square scale Triangle scale triangle");
    pdeg.addRule("Square", "square scale Square");
    pdeg.addRule("Square", "square push left Square pop push right Square pop");
    System.out.println("from pyprocessing import *\n\n");
    System.out.println("def setup():");
    System.out.println("\tsize(550, 550)\n\tbackground(255)\n\trectMode(CENTER)");
    System.out.println("\ttranslate(width/2,height/2)");
    System.out.println("\tfill(0, 0, 240, 32)\n\tnoStroke()");
    pdeg.expand("Drawing");
    System.out.println("\n\nrun()");
  }

  public void renderExpansion(String s) {
        switch (s) {
            case "push":
                System.out.println("\tpushMatrix()");
                break;
            case "pop":
                System.out.println("\tpopMatrix()");
                break;
            case "left":
                System.out.println("\ttranslate(-125, 0)");
                System.out.println("\tscale(0.45)");
                break;
            case "right":
                System.out.println("\ttranslate(125, 0)");
                System.out.println("\tscale(0.45)");
                break;
            case "square":
                System.out.println("\trect(0, 0, 500, 500)");
                break;
            case "scale":
                System.out.println("\tscale(0.75)");
                break;
            case "circle":
                System.out.println("\tellipse(0, 0, 500, 500)");
                break;
            case "triangle":
                System.out.println("\ttriangle(-250, 250/sqrt(3), 0, -500/sqrt(3), 250, 250/sqrt(3))");
                break;  
            case "rotate":
                System.out.println("\trotate(radians(45))");
                break;      
        }
    
  }

}
