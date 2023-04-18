/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Diogo
 */
public class Individuo implements Comparable<Individuo>{
    
    private int tamanho = 72;
    
    private String cromossomoBinario;
    private double aptidao;

    public String getCromossomo() {
        return cromossomoBinario;
    }

    public void setCromossomo(String cromossomo) {
        this.cromossomoBinario = cromossomo;
    }
    
    public void setCromossomo2(String cromossomo) {
        this.cromossomoBinario = this.cromossomoBinario + cromossomo;
    }

    public double getAptidao() {
        return aptidao;
    }

    public void setAptidao(double aptidao) {
        this.aptidao = aptidao;
    }
    
    public Individuo(){
        cromossomoBinario = "";
        for (int i = 0; i < tamanho; i++) {
            if(Math.random()<0.5){
                cromossomoBinario = cromossomoBinario + "1";
            }else{
                cromossomoBinario = cromossomoBinario + "0";
            }
        }
    }
    
    public Individuo(String a){
        this.cromossomoBinario = "";
    }
    
    //DADOS PARA O ALGORITMO
    
    //Quantidade de qualidades de café existentes (é o mesmo valor também da quantidade de proços existentes)
    private static int qtdQualidadeCafe = 4;
    // quantidade de meses da colheita(a mesma quantidade de elementos no T(tal)__custoColheita_mes_tipo)
    private static int qtdMesesColheita = 10;//é 5
    //custo do beneficiamento em R$/sc
    private static double custoBeneficiamento = 4.5; // o 150 está em hectare (foi convertido direto na função)
    //custo administrativo em R$/ha
    private static double custoAdministrativo = 48427.50;
    
    // area de cada um dos 8 talões da fazenda em hectares
    private static double area[] = {5.7, 10, 2.5, 4, 5, 5.4, 9.2, 16.9};
    
    // preço da saca de café em R$ para cada uma das qualidades: cereja, verde, boia, varrecao.
    private static double precoCafe[] = {300, 180, 200, 150};
    
    //Proporção da produção de café por qualidade por talhão
    //porcentagem de café da qualidade q produzido por talhão t (todos os talhões recebem essa proporção para: cereja,verde,boia,varrecao)
    private static double qualidade[] = {0.3, 0.12, 0.49, 0.09};
    
    // Produção do talhão em saca/ha conforme adubação macronutriente, micronutriente e controle de defensivo aplicado
    private static int T1_producao_ha[] ={72, 72, 76, 72, 72, 76, 72, 72, 76, 68, 68, 72, 68, 68, 72, 68, 68, 72};
    private static int T2_producao_ha[] ={24, 24, 26, 24, 24, 26, 24, 24, 26, 23, 23, 24, 23, 23, 24, 23, 23, 24};
    private static int T3_producao_ha[] ={41, 41, 43, 41, 41, 43, 41, 41, 43, 38, 38, 41, 38, 38, 41, 38, 38, 41};
    private static int T4_producao_ha[] ={0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static int T5_producao_ha[] ={90, 90, 95, 90, 90, 95, 90, 90, 95, 86, 86, 90, 86, 86, 90, 86, 86, 90};
    private static int T6_producao_ha[] ={27, 27, 29, 27, 27, 29, 27, 27, 29, 26, 26, 27, 26, 26, 27, 26, 26, 27};
    private static int T7_producao_ha[] ={47, 47, 49, 47, 47, 49, 47, 47, 49, 44, 44, 47, 44, 44, 47, 44, 44, 47};
    private static int T8_producao_ha[] ={30, 30, 31, 30, 30, 31, 30, 30, 31, 28, 28, 30, 28, 28, 30, 28, 28, 30};
    
    // Gastos com insumos de adubação e controle fitossanitário, em R$/ha
    private static double T1_custo_producao_ha[] = {2539.56, 2543.46, 2866.82, 2539.56, 2543.46, 2866.82, 2476.43, 2803.69, 2803.69, 2323.56, 2327.46, 2650.82, 2323.56, 2327.46, 2650.82, 2260.43, 2264.33, 2587.69};
    private static double T2_custo_producao_ha[] = {2176.56, 2180.46, 2503.82, 2176.56, 2180.46, 2503.82, 2125.43, 2129.33, 2452.69, 1960.56, 1964.46, 2287.82, 1960.56, 1964.46, 2287.82, 1909.43, 1913.33, 2236.69};
    private static double T3_custo_producao_ha[] = {2297.56, 2301.46, 2624.82, 2297.56, 2301.46, 2624.82, 2242.43, 2246.33, 2569.69, 1960.56, 2085.46, 2408.82, 2081.56, 2085.46, 2408.82, 2026.43, 2030.33, 2353.69};
    private static double T4_custo_producao_ha[] = {2175.16, 2177.76, 2443.82, 2175.16, 2177.76, 2443.82, 2242.43, 2126.63, 2392.69, 1959.16, 1961.76, 2227.82, 1959.16, 1961.76, 2227.82, 2026.43, 1910.63, 2176.69};
    private static double T5_custo_producao_ha[] = {2660.56, 2664.46, 2987.82, 2660.56, 2664.46, 2987.82, 2593.43, 2597.33, 2920.69, 2444.56, 2448.46, 2771.82, 2444.56, 2448.46, 2771.82, 2377.43, 2381.33, 2704.69};
    private static double T6_custo_producao_ha[] = {2176.56, 2180.46, 2503.82, 2176.56, 2180.46, 2503.82, 2125.43, 2129.33, 2452.69, 1960.56, 1964.46, 2287.82, 1960.56, 1964.46, 2287.82, 1909.43, 1913.33, 2236.69};
    private static double T7_custo_producao_ha[] = {2297.56, 2301.46, 2624.82, 2297.56, 2301.46, 2624.82, 2242.43, 2246.33, 2569.69, 2081.56, 2085.46, 2408.82, 2081.56, 2085.46, 2408.82, 2026.43, 2030.33, 2353.69};
    private static double T8_custo_producao_ha[] = {2176.56, 2180.46, 2503.82, 2176.56, 2180.46, 2503.82, 2125.43, 2129.33, 2452.69, 1960.56, 1960.56, 2287.82, 1960.56, 1964.46, 2287.82, 1909.43, 1913.33, 2236.69};
    
    // Custo da colheita em R$/ha conforme talhão, mês e tipo de colheita
    //maio MAN, junho MAN, julho MAN, agosto MAN, setembro MAN, maio MAQ, junho MAQ, julho MAQ, agosto MAQ, setembro MAQ
    private static double T1_custoColheita_mes_tipo[] = {640, 640, 640, 640, 640, 224, 218, 214, 209, 203};
    private static double T2_custoColheita_mes_tipo[] = {216, 216, 216, 216, 216, 224, 218, 214, 209, 203};
    private static double T3_custoColheita_mes_tipo[] = {360, 360, 360, 360, 360, 224, 218, 214, 209, 203};
    private static double T4_custoColheita_mes_tipo[] = {0, 0, 0, 0, 0, 224, 218, 214, 209, 203};
    private static double T5_custoColheita_mes_tipo[] = {800, 800, 800, 800, 800, 224, 218, 214, 209, 203};
    private static double T6_custoColheita_mes_tipo[] = {240, 240, 240, 240, 240, 224, 218, 214, 209, 203};
    private static double T7_custoColheita_mes_tipo[] = {416, 416, 416, 416, 416, 224, 218, 214, 209, 203};
    private static double T8_custoColheita_mes_tipo[] = {264, 264, 264, 264, 264, 224, 218, 214, 209, 203};
    
    private static String adubacao[] = {"A7A11L1", "A7A13L1", "A7A15L1", "A8A11L1", "A8A13L1", "A8A15L1", "A9A11L1", "A9A13L1", "A9A15L1", "A7A11L2", "A7A13L2", "A7A15L2", "A8A11L2", "A8A13L2", "A8A15L2", "A9A11L2", "A9A13L2", "A9A15L2"};
    private static String tipo_colheita[] = {"Maio-MANUAL", "Junho-MANUAL", "Julho-MANUAL", "Agosto-MANUAL", "Setembro-MANUAL", "Maio-MAQUINA", "Junho-MAQUINA", "Julho-MAQUINA", "Agosto-MAQUINA", "Setembro-MAQUINA"};
    
    public int fatorTalhao(int talhao){
        double fator = 0, posicao = 0;
        int posicaoInt = 0;
        String binario;
        
        fator = ((17-0)/((Math.pow(2, 5)-1))
                +0);
        if(talhao == 1){
            binario = this.cromossomoBinario.substring(0, 5);
            posicao = Integer.parseInt(binario, 2)*fator;
            posicaoInt = (int) Math.round(posicao);
        }else if(talhao == 2){
            binario = this.cromossomoBinario.substring(5, 10);
            posicao = Integer.parseInt(binario, 2)*fator;
            posicaoInt = (int) Math.round(posicao);
        }else if(talhao == 3){
            binario = this.cromossomoBinario.substring(10, 15);
            posicao = Integer.parseInt(binario, 2)*fator;
            posicaoInt = (int) Math.round(posicao);
        }else if(talhao == 4){
            binario = this.cromossomoBinario.substring(15, 20);
            posicao = Integer.parseInt(binario, 2)*fator;
            posicaoInt = (int) Math.round(posicao);
        }else if(talhao == 5){
            binario = this.cromossomoBinario.substring(20, 25);
            posicao = Integer.parseInt(binario, 2)*fator;
            posicaoInt = (int) Math.round(posicao);
        }else if(talhao == 6){
            binario = this.cromossomoBinario.substring(25, 30);
            posicao = Integer.parseInt(binario, 2)*fator;
            posicaoInt = (int) Math.round(posicao);
        }else if(talhao == 7){
            binario = this.cromossomoBinario.substring(30, 35);
            posicao = Integer.parseInt(binario, 2)*fator;
            posicaoInt = (int) Math.round(posicao);
        }else{
            binario = this.cromossomoBinario.substring(35, 40);
            posicao = Integer.parseInt(binario, 2)*fator;
            posicaoInt = (int) Math.round(posicao);
        }
        return posicaoInt;
    }
    
    public int fatorTalhao2(int talhao){
        double fator = 0, posicao = 0;
        int posicaoInt = 0;
        String binario;
        
        fator = ((9-0)/((Math.pow(2, 4)-1))
                +0);
        if(talhao == 1){
            binario = this.cromossomoBinario.substring(40, 44);
            posicao = Integer.parseInt(binario, 2)*fator;
            posicaoInt = (int) Math.round(posicao);
        }else if(talhao == 2){
            binario = this.cromossomoBinario.substring(44, 48);
            posicao = Integer.parseInt(binario, 2)*fator;
            posicaoInt = (int) Math.round(posicao);
        }else if(talhao == 3){
            binario = this.cromossomoBinario.substring(48, 52);
            posicao = Integer.parseInt(binario, 2)*fator;
            posicaoInt = (int) Math.round(posicao);
        }else if(talhao == 4){
            binario = this.cromossomoBinario.substring(52, 56);
            posicao = Integer.parseInt(binario, 2)*fator;
            posicaoInt = (int) Math.round(posicao);
        }else if(talhao == 5){
            binario = this.cromossomoBinario.substring(56, 60);
            posicao = Integer.parseInt(binario, 2)*fator;
            posicaoInt = (int) Math.round(posicao);
        }else if(talhao == 6){
            binario = this.cromossomoBinario.substring(60, 64);
            posicao = Integer.parseInt(binario, 2)*fator;
            posicaoInt = (int) Math.round(posicao);
        }else if(talhao == 7){
            binario = this.cromossomoBinario.substring(64, 68);
            posicao = Integer.parseInt(binario, 2)*fator;
            posicaoInt = (int) Math.round(posicao);
        }else{
            binario = this.cromossomoBinario.substring(68, 72);
            posicao = Integer.parseInt(binario, 2)*fator;
            posicaoInt = (int) Math.round(posicao);
        }
        return posicaoInt;
    }
    
    public double R(){
        double r = 0;
        int x;
            for(x = 0; x < qtdQualidadeCafe; x++){
                r = r + (precoCafe[x] * T1_producao_ha[fatorTalhao(1)] * qualidade[x] * area[0]);
            }
            for(x = 0; x < qtdQualidadeCafe; x++){
                r = r + (precoCafe[x] * T2_producao_ha[fatorTalhao(2)] * qualidade[x] * area[1]);
            }
            for(x = 0; x < qtdQualidadeCafe; x++){
                r = r + (precoCafe[x] * T3_producao_ha[fatorTalhao(3)] * qualidade[x] * area[2]);
            }
            for(x = 0; x < qtdQualidadeCafe; x++){
                r = r + (precoCafe[x] * T4_producao_ha[fatorTalhao(4)] * qualidade[x] * area[3]);
            }
            for(x = 0; x < qtdQualidadeCafe; x++){
                r = r + (precoCafe[x] * T5_producao_ha[fatorTalhao(5)] * qualidade[x] * area[4]);
            }
            for(x = 0; x < qtdQualidadeCafe; x++){
                r = r + (precoCafe[x] * T6_producao_ha[fatorTalhao(6)] * qualidade[x] * area[5]);
            }
            for(x = 0; x < qtdQualidadeCafe; x++){
                r = r + (precoCafe[x] * T7_producao_ha[fatorTalhao(7)] * qualidade[x] * area[6]);
            }
            for(x = 0; x < qtdQualidadeCafe; x++){
                r = r + (precoCafe[x] * T8_producao_ha[fatorTalhao(8)] * qualidade[x] * area[7]);
            }
        return r;
    }
    
    
    public double G(){
        double g = 0;
        g = g + (T1_custo_producao_ha[fatorTalhao(1)] * area[0]);
        g = g + (T2_custo_producao_ha[fatorTalhao(2)] * area[1]);
        g = g + (T3_custo_producao_ha[fatorTalhao(3)] * area[2]);
        g = g + (T4_custo_producao_ha[fatorTalhao(4)] * area[3]);
        g = g + (T5_custo_producao_ha[fatorTalhao(5)] * area[4]);
        g = g + (T6_custo_producao_ha[fatorTalhao(6)] * area[5]);
        g = g + (T7_custo_producao_ha[fatorTalhao(7)] * area[6]);
        g = g + (T8_custo_producao_ha[fatorTalhao(8)] * area[7]);
        
        return g;
    }
    
    public double C(){
        double c = 0;
        int x;
          
        c = c + (T1_custoColheita_mes_tipo[fatorTalhao2(1)] * area[0] * area[0]);
        c = c + (T1_custoColheita_mes_tipo[fatorTalhao2(2)] * area[1] * area[1]);
        c = c + (T1_custoColheita_mes_tipo[fatorTalhao2(3)] * area[2] * area[2]);
        c = c + (T1_custoColheita_mes_tipo[fatorTalhao2(4)] * area[3] * area[3]);
        c = c + (T1_custoColheita_mes_tipo[fatorTalhao2(5)] * area[4] * area[4]);
        c = c + (T1_custoColheita_mes_tipo[fatorTalhao2(6)] * area[5] * area[5]);
        c = c + (T1_custoColheita_mes_tipo[fatorTalhao2(7)] * area[6] * area[6]);
        c = c + (T1_custoColheita_mes_tipo[fatorTalhao2(8)] * area[7] * area[7]);
        
        return c;
    }
    
    public double B(){
        double b = 0;
        int x;
        
        /*
        b = b + (custoBeneficiamento / T1_producao_ha[fatorTalhao(1)]) * (T1_producao_ha[fatorTalhao(1)] * area[0]);
        b = b + (custoBeneficiamento / T1_producao_ha[fatorTalhao(2)]) * (T1_producao_ha[fatorTalhao(2)] * area[1]);
        b = b + (custoBeneficiamento / T1_producao_ha[fatorTalhao(3)]) * (T1_producao_ha[fatorTalhao(3)] * area[2]);
        b = b + (custoBeneficiamento / T1_producao_ha[fatorTalhao(4)]) * (T1_producao_ha[fatorTalhao(4)] * area[3]);
        b = b + (custoBeneficiamento / T1_producao_ha[fatorTalhao(5)]) * (T1_producao_ha[fatorTalhao(5)] * area[4]);
        b = b + (custoBeneficiamento / T1_producao_ha[fatorTalhao(6)]) * (T1_producao_ha[fatorTalhao(6)] * area[5]);
        b = b + (custoBeneficiamento / T1_producao_ha[fatorTalhao(7)]) * (T1_producao_ha[fatorTalhao(7)] * area[6]);
        b = b + (custoBeneficiamento / T1_producao_ha[fatorTalhao(8)]) * (T1_producao_ha[fatorTalhao(8)] * area[7]);
        */
        
        
        /*
        for(x = 0; x < qtdQualidadeCafe; x++){
            b = b + ((T1_producao_ha[fatorTalhao(1)] * qualidade[x] * custoBeneficiamento) * area[0]);
        }
        for(x = 0; x < qtdQualidadeCafe; x++){
            b = b + ((T2_producao_ha[fatorTalhao(2)] * qualidade[x] * custoBeneficiamento) * area[1]);
        }
        for(x = 0; x < qtdQualidadeCafe; x++){
            b = b + ((T3_producao_ha[fatorTalhao(3)] * qualidade[x] * custoBeneficiamento) * area[2]);
        }
        for(x = 0; x < qtdQualidadeCafe; x++){
            b = b + ((T4_producao_ha[fatorTalhao(4)] * qualidade[x] * custoBeneficiamento) * area[3]);
        }
        for(x = 0; x < qtdQualidadeCafe; x++){
            b = b + ((T5_producao_ha[fatorTalhao(5)] * qualidade[x] * custoBeneficiamento) * area[4]);
        }
        for(x = 0; x < qtdQualidadeCafe; x++){
            b = b + ((T6_producao_ha[fatorTalhao(6)] * qualidade[x] * custoBeneficiamento) * area[5]);
        }
        for(x = 0; x < qtdQualidadeCafe; x++){
            b = b + ((T7_producao_ha[fatorTalhao(7)] * qualidade[x] * custoBeneficiamento) * area[6]);
        }
        for(x = 0; x < qtdQualidadeCafe; x++){
            b = b + ((T8_producao_ha[fatorTalhao(8)] * qualidade[x] * custoBeneficiamento) * area[7]);
        }
        */
        
        
        // O calculo médio do custo de Beneficiamento dos resultados de Milan (2008) equivalem a 10,97%
        b = this.R() * 0.10965;
        
        return b;
    }
    
    public double D(){
        double d = custoAdministrativo;
  
        return d;
    }
    
    public double E(){
        double e = 0;
        
        e = e + T1_producao_ha[fatorTalhao(1)] * qualidade[0] * area[0];
        e = e + T2_producao_ha[fatorTalhao(2)] * qualidade[0] * area[1];
        e = e + T3_producao_ha[fatorTalhao(3)] * qualidade[0] * area[2];
        e = e + T4_producao_ha[fatorTalhao(4)] * qualidade[0] * area[3];
        e = e + T5_producao_ha[fatorTalhao(5)] * qualidade[0] * area[4];
        e = e + T6_producao_ha[fatorTalhao(6)] * qualidade[0] * area[5];
        e = e + T7_producao_ha[fatorTalhao(7)] * qualidade[0] * area[6];
        e = e + T8_producao_ha[fatorTalhao(8)] * qualidade[0] * area[7];
        
        return e;
    }
    
    public double Z(){
        double z = 0;
        int x;
        for(x = 0; x < 4; x++){
            z = z + T1_producao_ha[fatorTalhao(1)] * qualidade[x] * area[0];
        }
        for(x = 0; x < 4; x++){
            z = z + T2_producao_ha[fatorTalhao(2)] * qualidade[x] * area[1];
        }
        for(x = 0; x < 4; x++){
            z = z + T3_producao_ha[fatorTalhao(3)] * qualidade[x] * area[2];
        }
        for(x = 0; x < 4; x++){
            z = z + T4_producao_ha[fatorTalhao(4)] * qualidade[x] * area[3];
        }
        for(x = 0; x < 4; x++){
            z = z + T5_producao_ha[fatorTalhao(5)] * qualidade[x] * area[4];
        }
        for(x = 0; x < 4; x++){
            z = z + T6_producao_ha[fatorTalhao(6)] * qualidade[x] * area[5];
        }
        for(x = 0; x < 4; x++){
            z = z + T7_producao_ha[fatorTalhao(7)] * qualidade[x] * area[6];
        }
        for(x = 0; x < 4; x++){
            z = z + T8_producao_ha[fatorTalhao(8)] * qualidade[x] * area[7];
        }

        return z;
    }
    
    public double L(){
        
        return (this.R() - this.G() - this.C() - this.D() - this.B());
        
    }
    
    public void aptidao(int pesoL, int pesoG, int pesoC, int pesoZ, int pesoE){
        
        this.setAptidao(this.aptidao = ((pesoL * this.L()) - (pesoG * this.G()) - (pesoC * this.C()) + (pesoZ * this.Z()) + (pesoE * this.E())));
        
    }
    
    public void adubo(){
        
        System.out.println("ADUBAÇÃO");
        System.out.println("Talhão 1: "+this.adubacao[fatorTalhao(1)]);
        System.out.println("Talhão 2: "+this.adubacao[fatorTalhao(2)]);
        System.out.println("Talhão 3: "+this.adubacao[fatorTalhao(3)]);
        System.out.println("Talhão 4: "+this.adubacao[fatorTalhao(4)]);
        System.out.println("Talhão 5: "+this.adubacao[fatorTalhao(5)]);
        System.out.println("Talhão 6: "+this.adubacao[fatorTalhao(6)]);
        System.out.println("Talhão 7: "+this.adubacao[fatorTalhao(7)]);
        System.out.println("Talhão 8: "+this.adubacao[fatorTalhao(8)]);
        
    }
    
    public void colheita(){
        System.out.println("MÊS e TIPO DE COLHEITA");
        System.out.println("Talhão 1: "+this.tipo_colheita[fatorTalhao2(1)]);
        System.out.println("Talhão 2: "+this.tipo_colheita[fatorTalhao2(2)]);
        System.out.println("Talhão 3: "+this.tipo_colheita[fatorTalhao2(3)]);
        System.out.println("Talhão 4: "+this.tipo_colheita[fatorTalhao2(4)]);
        System.out.println("Talhão 5: "+this.tipo_colheita[fatorTalhao2(5)]);
        System.out.println("Talhão 6: "+this.tipo_colheita[fatorTalhao2(6)]);
        System.out.println("Talhão 7: "+this.tipo_colheita[fatorTalhao2(7)]);
        System.out.println("Talhão 8: "+this.tipo_colheita[fatorTalhao2(8)]);
    }
    
    // Ordena do maior para o menor a aptidão
    @Override
    public int compareTo(Individuo o) {
        if(this.aptidao > o.aptidao){
            return -1;
        }
        if(this.aptidao < o.aptidao){
            return 1;
        }
        return 0;
    }
    
    
}
