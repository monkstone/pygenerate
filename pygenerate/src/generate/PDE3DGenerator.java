package generate;

public class PDE3DGenerator extends ContextFree {

    public static int MAX_RECURSION = 200;

    public static void main(String[] args) {
        PDE3DGenerator pdeg = new PDE3DGenerator();
        pdeg.setMaxRecursion(MAX_RECURSION);
        pdeg.addRule("Drawing", "Box");
        pdeg.addRule("Box", "box", 0.01f);
        pdeg.addRule("Box", "box scale sphere");
        pdeg.addRule("Box", "box scale Box");
        pdeg.addRule("Box", "box push left Box pop push right Box pop");
        System.out.println("import processing.opengl.*;\n\n\n");
        System.out.println("void setup(){");
        System.out.println("\tsize(512, 512, OPENGL);");
        System.out.println("\ttranslate(width/2, height/2, height/2);");
        System.out.println("\tfill(0, 0, 240, 32);\n\tnoStroke();");
        // Change height of the camera with mouseY
        System.out.println("}\n\n\nvoid draw(){\n\tbackground(255);");
        System.out.println("\tcamera(30.0, 100, mouseY,"); // eyeX, eyeY, eyeZ
        System.out.println("\t\t0.0, 0.0, 0.0,"); // centerX, centerY, centerZ
        System.out.println("\t\t 0.0, 1.0, 0.0);"); // upX, upY, upZ
        System.out.println("\trotateY(mouseX/360);;\n\thint(DISABLE_DEPTH_TEST);");
        pdeg.expand("Drawing");
        System.out.println("}");
    }

    /**
     * Exploring the new switch feature of jdk 7.0 (supports String)
     * @param s String
     */
    public void renderExpansion(String s) {
        switch (s) {
            case "push":
                System.out.println("\tpushMatrix();");
                break;
            case "pop":
                System.out.println("\tpopMatrix();");
                break;
            case "left":
                System.out.println("\ttranslate(-125, 0);");
                System.out.println("\tscale(0.45);");
                break;
            case "right":
                System.out.println("\ttranslate(125, 0);");
                System.out.println("\tscale(0.45);");
                break;
            case "box":
                System.out.println("\tbox(180, 180, 180);");
                break;
            case "scale":
                System.out.println("\tscale(0.75);");
                break;
            case "sphere":
                System.out.println("\tsphere(150);");
                break;
        }

    }
}
