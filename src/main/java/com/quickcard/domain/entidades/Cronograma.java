package com.quickcard.domain.entidades;

public class Cronograma {

    public Cronograma() {

    }

    String nome;
    short[] diasSemanas;
    int minutosCicloEstudos;
    int minutosIntervalos;
    String recompensaIntervalo;
    int quantidadeCliclos;
    String materias;
    /*
    cronogramaDia:CronogramaDia[];
    */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public short[] getDiasSemanas() {
        return diasSemanas;
    }

    public void setDiasSemanas(short[] diasSemanas) {
        this.diasSemanas = diasSemanas;
    }

    public int getMinutosCicloEstudos() {
        return minutosCicloEstudos;
    }

    public void setMinutosCicloEstudos(int minutosCicloEstudos) {
        this.minutosCicloEstudos = minutosCicloEstudos;
    }

    public int getMinutosIntervalos() {
        return minutosIntervalos;
    }

    public void setMinutosIntervalos(int minutosIntervalos) {
        this.minutosIntervalos = minutosIntervalos;
    }

    public String getRecompensaIntervalo() {
        return recompensaIntervalo;
    }

    public void setRecompensaIntervalo(String recompensaIntervalo) {
        this.recompensaIntervalo = recompensaIntervalo;
    }

    public int getQuantidadeCliclos() {
        return quantidadeCliclos;
    }

    public void setQuantidadeCliclos(int quantidadeCliclos) {
        this.quantidadeCliclos = quantidadeCliclos;
    }

    public String getMaterias() {
        return materias;
    }

    public void setMaterias(String materias) {
        this.materias = materias;
    }
}
