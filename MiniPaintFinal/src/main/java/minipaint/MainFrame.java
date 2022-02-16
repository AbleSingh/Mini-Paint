package minipaint;

/* ------------------------------------ Imports ------------------------------------------ */
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/* ------------------------------------ /Imports ------------------------------------------ */



public class MainFrame {



    /* ------------------------------------ Static variable declaration ------------------------------------------ */
    static Color mycolor;
    static public int choicesel = 1;
    static public int fillsel = 0;
    static public int strokeWeight = 1;
    /* ------------------------------------ /Static variable declaration ------------------------------------------ */




    public static void main(String[] args) {




        /* ------------------------------------Declaration of different variables------------------------------------------ */
        //frames
        JFrame f = new JFrame("Java Project - Mini Paint");

        //graphics
        Graphics g = null;

        //JPanels
        JPanel buttonSection, colorSection, basebg, fillSection, nameSection, thicksection, saveressection;

        //JButtons
        JButton tool1, tool2, tool3, tool4, tool5, tool6, tool7, tool8, tool9, tool10, colorset, reset, save;

        //Container
        Container c;

        //label
        JLabel saksham, naveen, arihant, sushant, thick;

        //radioButton
        JRadioButton rad1, rad2;

        //ButtonGroup
        ButtonGroup fill;
        /* ------------------------------------/Declaration of different variables------------------------------------------ */




        /* ---------------------------- Multi Screen Support ------------------------------ */
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = environment.getMaximumWindowBounds();
        int width = (int) bounds.width;
        int height = (int) bounds.height;
        /* ---------------------------- /Multi Screen Support ----------------------------- */




        /* ------------------------------------Icon Source definition------------------------------------------ */
        Icon icon = new ImageIcon("icons/rectangle.jpg");
        Icon icon1 = new ImageIcon("icons/line.jpg");
        Icon icon2 = new ImageIcon("icons/square.jpg");
        Icon icon3 = new ImageIcon("icons/oval.jpg");
        Icon icon4 = new ImageIcon("icons/circle.jpg");
        Icon icon5 = new ImageIcon("icons/roundrectangle.jpg");
        Icon icon6 = new ImageIcon("icons/pen.jpg");
        Icon icon7 = new ImageIcon("icons/eraser.jpg");
//        Icon icon8 = new ImageIcon("icons/colorpick.jpg"); -----> Later replaced with current colour instance
        Icon icon9 = new ImageIcon("icons/palette.jpg");
        Icon icon10 = new ImageIcon("icons/doublepen.jpg");
        Icon saveIcon = new ImageIcon("icons/save.jpg");
        Icon resetIcon = new ImageIcon("icons/reset.jpg");
        /* ------------------------------------/Icon Source definition------------------------------------------ */




        /* ------------------------------------Creation of Buttons with Icon------------------------------------------ */
        tool1 = new JButton(icon);
        tool2 = new JButton(icon1);
        tool3 = new JButton(icon2);
        tool4 = new JButton(icon3);
        tool5 = new JButton(icon4);
        tool6 = new JButton(icon5);
        tool7 = new JButton(icon6);
        tool8 = new JButton(icon7);
        tool9 = new JButton(icon9);
        tool10 = new JButton(icon10);
        /* ------------------------------------/Creation of Buttons with Icon------------------------------------------ */




        /* ------------------------------------Colour Picker Creation------------------------------------------ */
        c = f.getContentPane();
        c.setLayout(new FlowLayout());
        colorset = new JButton("");
        colorset.setBackground(Color.BLACK);
        colorset.setOpaque(true);
        colorset.addActionListener(e -> {

            Color initialcolor = Color.BLACK;
            JColorChooser jcc = new JColorChooser();
            mycolor = jcc.showDialog(c, "Select a colour", initialcolor);
            colorset.setBackground(mycolor);
            colorset.setOpaque(true);
        });
        c.add(colorset);
        /* ------------------------------------/Colour Picker Creation------------------------------------------ */




        /* ------------------------------------PANEL 0 - BASE BACKGROUND------------------------------------------ */
        basebg = new JPanel();
        basebg.setLayout(null);
        basebg.setBackground(Color.DARK_GRAY);
        basebg.setVisible(true);
        basebg.setBounds(0, 0, width, height);
        /* ------------------------------------/PANEL 0 - BASE BACKGROUND------------------------------------------ */




        /* ------------------------------------PANEL 1 - BUTTON SECTION------------------------------------------ */
        buttonSection = new JPanel();
        buttonSection.setBounds(10, 10, 300, 120);
        buttonSection.setBackground(Color.DARK_GRAY);
        buttonSection.setLayout(new GridLayout(2, 5, 2, 2));
        buttonSection.setVisible(true);

        tool1.addActionListener(e -> {
            choicesel = 1;
        });
        tool2.addActionListener(e -> {
            choicesel = 2;
        });
        tool3.addActionListener(e -> {
            choicesel = 3;
        });
        tool4.addActionListener(e -> {
            choicesel = 4;
        });
        tool5.addActionListener(e -> {
            choicesel = 5;
        });
        tool6.addActionListener(e -> {
            choicesel = 6;
        });
        tool7.addActionListener(e -> {
            choicesel = 7;
        });
        tool8.addActionListener(e -> {
            choicesel = 8;
        });
        tool9.addActionListener(e -> {
            choicesel = 9;
        });
        tool10.addActionListener(e -> {
            choicesel = 10;
        });




        /* ------------------------------------BUTTON TOOLTIP------------------------------------------ */
        tool1.setToolTipText("Rectangle");
        tool2.setToolTipText("Straight Line");
        tool3.setToolTipText("Square");
        tool4.setToolTipText("Oval");
        tool5.setToolTipText("Circle");
        tool6.setToolTipText("Rounded Rectangle");                      //On hover display of Tool name
        tool7.setToolTipText("Freestyle Pen");
        tool8.setToolTipText("Eraser");
        tool9.setToolTipText("Colourful Design");
        tool10.setToolTipText("Multi Stroke Pen");
        colorset.setToolTipText("Colour Picker");
        /* ------------------------------------BUTTON TOOLTIP------------------------------------------ */




        buttonSection.add(tool1);
        buttonSection.add(tool2);
        buttonSection.add(tool3);
        buttonSection.add(tool4);
        buttonSection.add(tool5);                                       //Adding Buttons to Grid Layout of Panel 1
        buttonSection.add(tool6);
        buttonSection.add(tool7);
        buttonSection.add(tool8);
        buttonSection.add(tool9);
        buttonSection.add(tool10);
        /* ------------------------------------/PANEL 1 - BUTTON SECTION------------------------------------------ */




        /* ------------------------------------PANEL 2 - COLOR SECTION------------------------------------------ */
        colorSection = new JPanel();
        colorSection.add(colorset);
        colorSection.setBounds(320, 10, 120, 120);      //Colour Selection from various Options
        colorSection.setLayout(new GridLayout(1, 1));
        colorSection.setVisible(true);
        /* ------------------------------------/PANEL 2 - COLOR SECTION------------------------------------------ */




        /* ------------------------------------PANEL 3 - PAINTSCREEN PANEL------------------------------------------ */
        DrawPanel paintscreen = new DrawPanel();
        paintscreen.setBackground(Color.WHITE);                                         //Creating Panel 2 as an instance of DrawPanel Class
        paintscreen.setBounds(10, 140, width - 25, height - 175);    //This will be actual Paint Screen of Program
        paintscreen.setVisible(true);
        /* ------------------------------------/PANEL 3 - PAINTSCREEN PANEL------------------------------------------ */




        /* ------------------------------------Radio Button define------------------------------------------ */
        rad1 = new JRadioButton("No Fill");
        rad1.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
        rad1.setForeground(Color.white);
        rad1.setSelected(true);
        rad1.setBackground(Color.DARK_GRAY);
        rad1.setSize(100, 40);
        rad1.addActionListener(e -> {
            fillsel = 0;
        });
        //These radio buttons define weather fill
        rad2 = new JRadioButton("Fill Colour");                        //is active or no fill is active
        rad2.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
        rad2.setForeground(Color.white);
        rad2.setSelected(false);
        rad2.setBackground(Color.DARK_GRAY);
        rad2.setSize(100, 40);
        rad2.addActionListener(e -> {
            fillsel = 1;
        });

        fill = new ButtonGroup();                                            //Button grp makes only one selection sure
        fill.add(rad1);
        fill.add(rad2);
        /* ------------------------------------Radio Button Define------------------------------------------ */




        /* ------------------------------------PANEL 4 - FILL SECTION------------------------------------------ */
        fillSection = new JPanel();
        fillSection.setBounds(451, 10, 260, 50);
        fillSection.setLayout(new GridLayout(1, 2));
        fillSection.setVisible(true);                                         //Panel 4 contains fill rad buttons
        fillSection.setBackground(Color.DARK_GRAY);
        fillSection.add(rad1);
        fillSection.add(rad2);
        /* ------------------------------------/PANEL 4 - FILL SECTION------------------------------------------ */




        /* ------------------------------------PANEL 5 - NAME SECTION------------------------------------------ */
        nameSection = new JPanel();
        nameSection.setBounds(width - 340, 10, 320, 120);   //Panel 5 contains name of contributors
        nameSection.setVisible(true);
        nameSection.setBackground(Color.DARK_GRAY);
        /* ------------------------------------/PANEL 5 - NAME SECTION------------------------------------------ */




        /* ------------------------------------PANEL 6 - THICKNESS SECTION------------------------------------------ */
        thick = new JLabel("Thickness : ");
        thick.setForeground(Color.white);                                           //Thick Jlabel
        thick.setBackground(Color.DARK_GRAY);
        thick.setFont(new Font("Bodoni MT", Font.PLAIN, 20));


        JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 10, 1);
        slider.setBackground(Color.DARK_GRAY);
        slider.setForeground(Color.WHITE);
        slider.addChangeListener((ChangeEvent e) -> {                               //Thickness Slider for easy access
            JSlider source = (JSlider) e.getSource();
            if (!source.getValueIsAdjusting()) {
                strokeWeight = (int) source.getValue();
            }
        });
//        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);


        thicksection = new JPanel();
        thicksection.setBounds(451, 80, 330, 50);
        thicksection.setVisible(true);
        BorderLayout layout = new BorderLayout(1, 3);
        layout.setHgap(10);
        thicksection.setLayout(layout);                                            //Add and Align components to Panel 6
        thicksection.setBackground(Color.DARK_GRAY);
        thicksection.add(thick, BorderLayout.LINE_START);
        thicksection.add(slider, BorderLayout.LINE_END);
        /* ------------------------------------PANEL 6 - THICKNESS SECTION------------------------------------------ */




        /* ------------------------------------PANEL 7 - SAVE/RESET SECTION------------------------------------------ */
        save = new JButton(saveIcon);
        save.setFont(new Font("Bodoni MT", Font.PLAIN, 20));       //Save Button to save the paintscreen image
        save.addActionListener(e -> {
            try {
                Robot robot = new Robot();
                Rectangle captureRect = new Rectangle(10, 208, width - 25, height - 175);
                BufferedImage screenFullImage = robot.createScreenCapture(captureRect);
                ImageIO.write(screenFullImage,"png", new File("Saved.png"));
            } catch (AWTException | IOException ex) {
                System.err.println(ex);
            }
        });


        reset = new JButton(resetIcon);
        reset.setFont(new Font("Bodoni MT", Font.PLAIN, 20));           //Reset button in order to clear All
        reset.addActionListener(e -> {
            paintscreen.repaint();
            mycolor = Color.BLACK;
            colorset.setBackground(Color.BLACK);
            choicesel = 1;
            rad1.setSelected(true);
            fillsel = 0;
        });


        saveressection = new JPanel();
        saveressection.setBounds(850, 40, 100, 90);
        saveressection.setVisible(true);
        BorderLayout layout1 = new BorderLayout(1, 20);
        saveressection.setLayout(layout1);                                         //Add and Align components to Panel 7
        saveressection.setBackground(Color.DARK_GRAY);
        saveressection.add(save, BorderLayout.NORTH);
        saveressection.add(reset, BorderLayout.SOUTH);
        /* ------------------------------------/PANEL 7 - SAVE/RESET SECTION------------------------------------------ */




        /* ------------------------------------ Add Panel 1,2,3,4,5,6 to Panel 0 ------------------------------------------ */
        basebg.add(buttonSection);
        basebg.add(colorSection);
        basebg.add(paintscreen);                                    //Addition of All Panels to Base Panel basebg
        basebg.add(fillSection);
        basebg.add(nameSection);
        basebg.add(thicksection);
        basebg.add(saveressection);
        /* ------------------------------------ /Add Panel 1,2,3,4,5,6 to Panel 0 ------------------------------------------ */




        /* ------------------------------------ Base Frame values ------------------------------------------ */
        f.add(basebg);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setSize(width - 10, 1000);                    //Setting Up the base panel on Frame and designing Base Frame
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
        /* ------------------------------------ /Base Frame values ------------------------------------------ */


    }

}


class DrawPanel extends JPanel {




    /* ------------------------------------ Properties ------------------------------------------ */
    private final int DEFAULT_WIDTH = 1600;
    private final int DEFAULT_HEIGHT = 900;
    private final Color BACK_COLOR = Color.WHITE;
    /* ------------------------------------ /Properties ------------------------------------------ */




    /* ------------------------------------ Variables ------------------------------------------ */
    private int x1, y1, x2, y2;
    private MyMouseHandler handler;
    public Graphics g;
    /* ------------------------------------ /Variables ------------------------------------------ */




    /* ------------------------------------ Constructor ------------------------------------------ */
    public DrawPanel() {
        setBackground(BACK_COLOR);
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));

        handler = new MyMouseHandler();

        this.addMouseListener(handler);
        this.addMouseMotionListener(handler);
    }
    /* ------------------------------------ /Constructor ------------------------------------------ */




    /* ------------------------------------ Method ------------------------------------------ */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void setUpDrawingGraphics() {
        MainFrame m = new MainFrame();
        g = getGraphics();
        g.setColor(m.mycolor);
    }
    /* ------------------------------------ /Method ------------------------------------------ */




    /* ------------------------------------ Inner Class ------------------------------------------ */
    private class MyMouseHandler extends MouseAdapter {


        /* ------------------------ Mouse Pressed --------------------------- */
        public void mousePressed(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY();

            setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));  //Crosshair Cursor for easy precision -- returns back to normal once released

            setUpDrawingGraphics();
            MainFrame m1 = new MainFrame();
            if (m1.choicesel == 7) {
                x2 = x1;
                y2 = y1;
            }

            if (m1.choicesel == 8) {
                x2 = x1;
                y2 = y1;
            }

            if (m1.choicesel == 10) {
                x2 = x1;
                y2 = y1;
            }

        }
        /* ------------------------ /Mouse Pressed --------------------------- */




        /* ------------------------ Mouse Released --------------------------- */
        public void mouseReleased(MouseEvent e) {
            x2 = e.getX();
            y2 = e.getY();

            MainFrame m1 = new MainFrame();
            if (m1.fillsel == 0) { //makes the no fill active
                if (m1.choicesel == 1) {
                    for (int i = 0; i < m1.strokeWeight; i++) {
                        g.drawRect(x1 + i, y1 + i, x2 - x1, y2 - y1); //draws a rectangle
                    }
                } else if (m1.choicesel == 2) {
                    for (int i = 0; i < m1.strokeWeight; i++) {
                        g.drawLine(x1 + i, y1 + i, x2 + i, y2 + i); //draws a staright line betwwen two points
                    }
                } else if (m1.choicesel == 3) {
                    for (int i = 0; i < m1.strokeWeight; i++) {
                        g.drawRect(x1 + i, y1 + i, x2 - x1, x2 - x1); //draws a sqaure
                    }
                } else if (m1.choicesel == 4) {
                    for (int i = 0; i < m1.strokeWeight; i++) {
                        g.drawOval(x1 + i, y1 + i, x2 - x1, y2 - y1); //draws an oval
                    }
                } else if (m1.choicesel == 5) {
                    for (int i = 0; i < m1.strokeWeight; i++) {
                        g.drawOval(x1 + i, y1 + i, x2 - x1 + i, x2 - x1 + i); //draws a circle
                    }
                } else if (m1.choicesel == 6) {
                    for (int i = 0; i < m1.strokeWeight; i++) {
                        g.drawRoundRect(x1 + i, y1 + i, x2 - x1, y2 - y1, y2 - y1, x2 - x1); //draws a round rectangle
                    }
                }
            } else if (m1.fillsel == 1) { //makes the fill active
                if (m1.choicesel == 1) {
                    g.fillRect(x1, y1, x2 - x1, y2 - y1);//draws a rectangle
                } else if (m1.choicesel == 2) {
                    int i = 0;
                    for (i = 0; i < m1.strokeWeight; i++) {
                        g.drawLine(x1 + i, y1 + i, x2 + i, y2 + i); //draws a staright line betwwen two points
                    }
                } else if (m1.choicesel == 3) {
                    g.fillRect(x1, y1, x2 - x1, x2 - x1); //draws a sqaure
                } else if (m1.choicesel == 4) {
                    g.fillOval(x1, y1, x2 - x1, y2 - y1); //draws an oval
                } else if (m1.choicesel == 5) {
                    g.fillOval(x1, y1, x2 - x1, x2 - x1); //draws a circle
                } else if (m1.choicesel == 6) {
                    g.fillRoundRect(x1, y1, x2 - x1, y2 - y1, y2 - y1, x2 - x1); //draws a round rectangle
                }
            }

            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        }
        /* ------------------------ /Mouse Released --------------------------- */




        /* ------------------------ Mouse Dragged --------------------------- */
        public void mouseDragged(MouseEvent e) {

            setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));      //Crosshair Cursor for easy precision -- returns back to normal once released
            MainFrame m1 = new MainFrame();

            if (m1.choicesel == 7) {
                x1 = e.getX();
                y1 = e.getY();
                int i = 0;
                for (i = 0; i < m1.strokeWeight; i++) {
                    g.drawLine(x1 + i, y1 +i, x2 + i, y2 + i);
                }
                x2 = x1;
                y2 = y1;
            }

            if (m1.choicesel == 8) {
                x1 = e.getX();
                y1 = e.getY();
                g.setColor(Color.white);
                g.fillRect(x1, y1, 10 * m1.strokeWeight, 10 * m1.strokeWeight);
                x2 = x1;
                y2 = y1;
            }

            if (m1.choicesel == 9) {
                x1 = e.getX();
                y1 = e.getY();
                g.drawLine(x1, y1, x2, y2);
            }

            if (m1.choicesel == 10) {
                x1 = e.getX();
                y1 = e.getY();
                int i = 0;
                for (i = 0; i < m1.strokeWeight; i++) {
                    g.drawLine(x1 + (4 * i), y1 + (4 * i), x2 + (4 * i), y2 + (4 * i));
                }

                x2 = x1;
                y2 = y1;
            }

        }
        /* ------------------------ Mouse Dragged --------------------------- */
    }
    /* ------------------------------------ /Inner Class ------------------------------------------ */
}