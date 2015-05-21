/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.idu0020.controller;


/**
 *
 * @author iiilja
 */
public class ShirtValidation {
        private static final int MAX_COST = 9999;

    public static ShirtError vld(String id, String cost, String size) {
        ShirtError error = new ShirtError();
        boolean ok = true;
        int costInt = 0;
        try {
            costInt = Integer.parseInt(cost);
        } catch (Exception e) {
            ok = false;
            error.setCost( "Only numbers");
        }
        if (costInt != 0 && costInt > MAX_COST) {
            error.setCost("Cost should be under 10000");
            ok = false;
        }

        try {
            Integer.parseInt(id);
        } catch (Exception e) {
            error.setCost("Dont touch id !");
            ok = false;
        }
        if (size.length() == 0) {
            error.setSize("Can not be empty");
            ok = false;
        }
        if (size.length() > 4) {
            error.setSize("Max 4 cahracters");
            ok = false;

        }
        return ok ? null : error;

    }
}