import javax.swing.JFrame;
public class RectangleViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      frame.setSize(600, 600);
      frame.setTitle("dat Mine");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      uiDriverComponent component = new uiDriverComponent();
      frame.add(component);

      frame.setVisible(true);
   }
}
