import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

class Beep
{
    static void message(String s,boolean check)
    {
        try
        {
            Toolkit.getDefaultToolkit();

            Image image=ImageIO.read(new File("C:/Users/rajjh/Desktop/Banque Zenith.jpg"));
            Icon icon=new ImageIcon(image);
            JOptionPane.showMessageDialog(null,s,"Banque Zenith Online Portal",JOptionPane.INFORMATION_MESSAGE,icon);
            
            if(check)
                System.exit(0);
        }
        catch(Exception e)
        {   }
    }
}
