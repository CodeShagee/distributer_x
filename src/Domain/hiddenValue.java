/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Shiyanrox
 */
public class hiddenValue {
  String visibleField;
  int hiddenField;

    public String getVisibleField() {
        return visibleField;
    }

    public void setVisibleField(String visibleField) {
        this.visibleField = visibleField;
    }

    public int getHiddenField() {
        return hiddenField;
    }

    public void setHiddenField(int hiddenField) {
        this.hiddenField = hiddenField;
    }
  
  
  public String toString()
  {
      return visibleField;
  }
}
