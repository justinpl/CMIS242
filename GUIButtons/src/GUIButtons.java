import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

/**
 * File Name   : GUIButtons.java
 * Author      : Justin Luce
 * Created on  : 22-09-2017
 * Description : 
 **/
public class GUIButtons extends JFrame
{
    // create button objects
    private JRadioButton houseR = new JRadioButton("House");
    private JRadioButton apartmentR = new JRadioButton("Apartment");
    private JCheckBox washDryC = new JCheckBox("In Unit W/D");  
    private JCheckBox centralAirC = new JCheckBox("Central A/C");
    private JCheckBox dishwasherC = new JCheckBox("Dishwasher");
    private JCheckBox stoveC = new JCheckBox("Stove/Oven");
    private JLabel propertyL = new JLabel("Property Type:", JLabel.CENTER);
    private JLabel amenitiesL = new JLabel("Amenities:", JLabel.CENTER);

    
    // construct GUI object
    public GUIButtons()
    {
        super("Find Rental");
        setSize(225, 275);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JPanel buttonsP = new JPanel();
        buttonsP.setLayout(new GridLayout(2,2));
        propertyL.setBorder(new MatteBorder(1, 1, 1 ,1 , Color.LIGHT_GRAY));
        buttonsP.add(propertyL);
        JPanel typeP = new JPanel();
        typeP.setLayout(new GridLayout(2,1));
        typeP.add(houseR);
        typeP.add(apartmentR);
        ButtonGroup bg = new ButtonGroup();
        bg.add(houseR);
        bg.add(apartmentR);
        typeP.setBorder(new MatteBorder(1, 1, 1 ,1 , Color.LIGHT_GRAY));
        buttonsP.add(typeP);
        amenitiesL.setBorder(new MatteBorder(1, 1, 1 ,1 , Color.LIGHT_GRAY));
        buttonsP.add(amenitiesL);
        JPanel AmenityP = new JPanel();
        AmenityP.setLayout(new GridLayout(4,1));
        AmenityP.add(washDryC);
        AmenityP.add(centralAirC);
        AmenityP.add(dishwasherC);
        AmenityP.add(stoveC);
        AmenityP.setBorder(new MatteBorder(1, 1, 1 ,1 , Color.LIGHT_GRAY));
        buttonsP.add(AmenityP);
        add(buttonsP);
    }
    public static void main(String[] args)
    {
        GUIButtons frame = new GUIButtons();
        frame.setVisible(true);
    }
}