/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import view.AVLBoard;

/**
 *
 * @author Evan-Ian-Ray
 */
public class BoardManager extends Controller{

    private final AVLBoard avlBoard;

    public BoardManager() {
        
        this.avlBoard = new AVLBoard();
        
        this.addActionListeners();
    }

    @Override
    protected void addActionListeners() {

        this.avlBoard.getShowTweetsButton().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent input_event) {

        Object eventSource = input_event.getSource();
        if ( this.isUpdatingBoard( eventSource ) ){
            this.drawTwitterUsers();
            this.drawTweets();
        }
    }
    
    private boolean isUpdatingBoard(Object input_eventSource){
        
        return input_eventSource == this.avlBoard.getShowTweetsButton();
    }
    
    private void drawTwitterUsers(){
        
    }
    
    private void drawTweets(){
        
    }
    
}
