// Alex Nouansacksy
// MSOE 2010 #6
import static java.lang.System.out;
import java.util.*;
public class MSOE2010_6 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        out.print("How many vertices: ");
        int vertices = keyboard.nextInt();
        ArrayList<int[]> polygon = new ArrayList<>();
        for (int i = 0; i < vertices;i++) {
            out.print("x: ");
            int x = keyboard.nextInt();
            out.print("y: ");
            int y = keyboard.nextInt();
            int[] add = {x, y};
            polygon.add(add);
        }
        double area = polyArea(polygon);
        out.println("Area: "+ area);
    }

    public static double polyArea(ArrayList<int[]> vertices) {
        int numVertices = vertices.size();
        double sum1 = 0;
        double sum2 = 0;

        for (int i = 0; i  < numVertices - 1; i++) {
            sum1 = sum1 + vertices.get(i)[0] * vertices.get(i+1)[1];
            sum2 = sum2 + vertices.get(i)[1] * vertices.get(i+1)[0];
        }

        sum1 = sum1 + vertices.get(numVertices - 1)[0] * vertices.get(0)[1];
        sum2 = sum2 + vertices.get(0)[0] * vertices.get(numVertices - 1)[1];

        double area = Math.abs(sum1 - sum2) / 2;
        return area;
    }
}
