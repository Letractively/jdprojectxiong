package com.ejd.web.vo.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class PaintVerifyCodeBean {
	
	private int fontSize;
	
	public PaintVerifyCodeBean() {
		
	}
    public void paint(Graphics2D g2d, Object obj) {
    
    	GenerateVerifyCode data = (GenerateVerifyCode) obj;
        
        int testLenght = data.getVerifyCode().length();
        fontSize = 28;
        Font font = new Font("Serif", Font.HANGING_BASELINE, fontSize);
        g2d.setFont(font);
        
        int x = 2;
        int y = 28;
        g2d.translate(x, y);
        Color color = new Color(data.getColor() );
         
        g2d.setPaint(new Color(255,0, 47, 30));
        AffineTransform origTransform = g2d.getTransform();
        g2d.shear(-0.5*data.getScale(), 0);
        g2d.scale(1, data.getScale());
        g2d.drawString(data.getVerifyCode(), 0, 0);
      
        g2d.setTransform(origTransform);
        g2d.setPaint(color);
        g2d.drawString(data.getVerifyCode(), 0, 0);
    }

}
