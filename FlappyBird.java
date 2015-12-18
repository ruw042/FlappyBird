import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class FlappyBird extends JFrame {
  private int x=360;
  private int y=240;
  private int height;
  private int x2=570;
  private int height2;
  private boolean result=false;
  private double acc=0.15;
  private double v=0;
  private Flappy bird=new Flappy();
  public FlappyBird() {
    Random r=new Random();
    height=r.nextInt(288);
    while(height<48)
    {height=r.nextInt(288);}
    height2=r.nextInt(288);
    while(height2<48)
    {height2=r.nextInt(288);}
    
    add(bird);
    
    bird.setFocusable(true);
  }
  

class Flappy extends JPanel{
  private ImageIcon imageIcon = new ImageIcon("angry-bird-icon.png");
  private Image image=imageIcon.getImage();
  private ImageIcon imageIcon2=new ImageIcon("TubeUpper.png");
  private Image image2=imageIcon2.getImage();
  private ImageIcon imageIcon3=new ImageIcon("TubeLower.png");
  private Image image3=imageIcon3.getImage();
  private ImageIcon imageIcon4=new ImageIcon("cloud.png");
  private Image image4=imageIcon4.getImage();
  private ImageIcon imageIcon5=new ImageIcon("gameover.jpg");
  private Image image5=imageIcon5.getImage();
  private ImageIcon imageIcon6=new ImageIcon("start.jpg");
  private Timer timer=new Timer(10, new TimerListener());
  private JButton b=new JButton("Replay");
  public Flappy(){
    
    this.setLayout(null);
    b.setBounds(295, 410, 60, 35);
    //Image image6=imageIcon6.getImage().getScaledInstance(b.getWidth(),b.getHeight(),imageIcon6.getImage().SCALE_DEFAULT);
    //imageIcon6=new ImageIcon(image6);
    //b.setIcon(imageIcon6);
    add(b);
    b.setVisible(false);
    b.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        result=false;
        timer.start();
        x=360;
        y=240;
        x2=570;
        Random r=new Random();
        height=r.nextInt(288);
        while(height<48)
        {height=r.nextInt(288);}
        height2=r.nextInt(288);
        while(height2<48)
        {height2=r.nextInt(288);}
        v=0;
        bird.requestFocusInWindow(); 
        b.setVisible(false);
      }
    });
                          
    timer.start();
    addKeyListener(new KeyAdapter(){
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
         v=-4;
         repaint();
        }
      }
    }); 
  }
  protected void paintComponent(Graphics g){
    super.paintComponent(g);
    
    g.drawImage(image4,0,0,this);
    if((x+60)>0)
    {
      g.drawImage(image3,x+3,0,54,height,this);
      g.drawImage(image2,x,height,60,12,this);
      g.drawImage(image2,x,height+132,60,12,this);
      g.drawImage(image3,x+3,height+144,54,336-height,this);
    }
    else
    {
      x=360;
      Random r=new Random();
      height=r.nextInt(288);
      while(height<48)
      {height=r.nextInt(288);}
      g.drawImage(image3,x+3,0,54,height,this);
      g.drawImage(image2,x,height,60,12,this);
      g.drawImage(image2,x,height+132,60,12,this);
      g.drawImage(image3,x+3,height+144,54,336-height,this);
    }
    
    if((x2+60)>0)
    {
      g.drawImage(image3,x2+3,0,54,height2,this);
      g.drawImage(image2,x2,height2,60,12,this);
      g.drawImage(image2,x2,height2+132,60,12,this);
      g.drawImage(image3,x2+3,height2+144,54,336-height2,this);
    }
    else
    {
      x2=360;
      Random r2=new Random();
      height2=r2.nextInt(288);
      while(height2<48)
      {height2=r2.nextInt(288);}
      g.drawImage(image3,x2+3,0,54,height2,this);
      g.drawImage(image2,x2,height2,60,12,this);
      g.drawImage(image2,x2,height2+132,60,12,this);
      g.drawImage(image3,x2+3,height2+144,54,336-height2,this);
    }
      
    g.drawImage(image, 90, y,30,30, this);
    if(result==true)
    {
     g.drawImage(image5,60,80,240,320,this);}
  }
  class TimerListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      v=v+acc;
      y=(int)(y+v);
      x=x-1;
      x2=x2-1;
      if(x<120&&x>30)
      {
        if((height+12)>y||y>(height+102))
        {timer.stop();
         result=true;
         b.setVisible(true);
        }
      }
      else if(x2<120&&x2>30)
      {
        if((height2+12)>y||y>(height2+102))
        {timer.stop();
         result=true;
         b.setVisible(true);
        }
      }
      repaint();
    }
  }
}
public static void main(String[] args) {
  JFrame frame=new FlappyBird();
  frame.setLocationRelativeTo(null); 
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  frame.setSize(360, 480); 
  frame.setVisible(true);
}
}
  
    
  