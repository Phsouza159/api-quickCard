package com.quickcard.service;

import com.quickcard.domain.interfaces.servico.IServicoBasico;

import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ServicoBasico implements IServicoBasico {

    public String hashSenha(String senhaPura) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = algorithm.digest(senhaPura.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            String senhaCodificada = hexString.toString();
            return senhaCodificada;

        } catch (Exception err) {

            Logger.getLogger(JwtUserDetailsService.class.getName()).log(Level.SEVERE, null, err);
            return "";
        }
    }
}
