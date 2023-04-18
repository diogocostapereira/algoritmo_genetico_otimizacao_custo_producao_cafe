/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Diogo
 */
public class CrossoverDoisPontos {
    
    public ArrayList<Individuo> crossoverDoisPontos(ArrayList<Individuo> populacaoAntiga, double txCrossover, double taxaMutacao, int pesoL, int pesoG, int pesoC, int pesoZ, int pesoE){
        ArrayList<Individuo> novaPopulacao = new ArrayList<>();
        ArrayList<Individuo> pais;
        Random gerador = new Random();
        double qtdCrossover;
        int qtdCrossoverInteiro, i, x = 0, pontoCorte1 = 0, pontoCorte2 = 0, aux;
        qtdCrossover = (populacaoAntiga.size() * (txCrossover / 100)) / 2;// divide tudo por dois pq são dois filhos gerados porvez
        qtdCrossoverInteiro = (int) Math.round(qtdCrossover);
        for(i = 1; i <= qtdCrossoverInteiro; i++){
            while(x < 1){
                pontoCorte1 = gerador.nextInt(72);//40 é o tamanho do cromossomo
                pontoCorte2 = gerador.nextInt(72);//40 é o tamanho do cromossomo
                if(pontoCorte1 != pontoCorte2){
                    x++;
                    aux = pontoCorte1;
                    if(aux > pontoCorte2){
                        pontoCorte1 = pontoCorte2;
                        pontoCorte2 = aux;
                    }
                }
            }
            pais = this.selecaoTorneio(3, populacaoAntiga, pesoL, pesoG, pesoC, pesoZ, pesoE);
                
            Individuo filho1 = new Individuo("");
            Individuo filho2 = new Individuo("");
                
            if(pontoCorte1 == 0){
                filho1.setCromossomo2(pais.get(1).getCromossomo().substring(pontoCorte1, pontoCorte2));
                filho1.setCromossomo2(pais.get(0).getCromossomo().substring(pontoCorte2, 72));
                    
                filho2.setCromossomo2(pais.get(0).getCromossomo().substring(pontoCorte1, pontoCorte2));
                filho2.setCromossomo2(pais.get(1).getCromossomo().substring(pontoCorte2, 72));
            }else{
                filho1.setCromossomo2(pais.get(0).getCromossomo().substring(0, pontoCorte1));
                filho1.setCromossomo2(pais.get(1).getCromossomo().substring(pontoCorte1, pontoCorte2));
                filho1.setCromossomo2(pais.get(0).getCromossomo().substring(pontoCorte2, 72));
                    
                filho2.setCromossomo2(pais.get(1).getCromossomo().substring(0, pontoCorte1));
                filho2.setCromossomo2(pais.get(0).getCromossomo().substring(pontoCorte1, pontoCorte2));
                filho2.setCromossomo2(pais.get(1).getCromossomo().substring(pontoCorte2, 72));
            }
            
            mutacao(filho1, taxaMutacao);
            mutacao(filho2, taxaMutacao);
            
            filho1.aptidao(pesoL, pesoG, pesoC, pesoZ, pesoE);
            filho2.aptidao(pesoL, pesoG, pesoC, pesoZ, pesoE);
            
            novaPopulacao.add(filho1);
            novaPopulacao.add(filho2);
            pais.clear();
        }
        
        //Elitismo
        //Collections.sort(populacaoAntiga);
        //Collections.reverse(populacaoAntiga);
        for(x = 0; x < populacaoAntiga.size(); x++){
            if(novaPopulacao.size() < populacaoAntiga.size()){
                novaPopulacao.add(populacaoAntiga.get(x));
            }else{
                x = populacaoAntiga.size() + 1;
            }
        }
        populacaoAntiga.clear();
        Collections.sort(novaPopulacao);//ordena do maior para menor (aptidão)
        return novaPopulacao;
    }
    
    public ArrayList<Individuo> selecaoTorneio(int qtdSelecionados, ArrayList<Individuo> populacao, int pesoL, int pesoG, int pesoC, int pesoZ, int pesoE){
        ArrayList<Individuo> candidatosPais1 = new ArrayList<>();
        ArrayList<Individuo> candidatosPais2 = new ArrayList<>();
        ArrayList<Individuo> pais = new ArrayList<>();
        Random gerador = new Random();
        int i = 0, x;
        for(x = 0; x < 1; ){
            while(i < qtdSelecionados){
                Individuo ind1 = new Individuo("");
                Individuo ind2 = new Individuo("");
                ind1.setCromossomo(populacao.get(gerador.nextInt(populacao.size())).getCromossomo());
                ind2.setCromossomo(populacao.get(gerador.nextInt(populacao.size())).getCromossomo());
                ind1.aptidao(pesoL, pesoG, pesoC, pesoZ, pesoE);
                ind2.aptidao(pesoL, pesoG, pesoC, pesoZ, pesoE);
                candidatosPais1.add(ind1);
                candidatosPais2.add(ind2);
                i++;
            }
            Collections.sort(candidatosPais1);
            Collections.sort(candidatosPais2);

            pais.add(candidatosPais1.get(0));
            pais.add(candidatosPais2.get(0));
            
            if(!pais.get(0).getCromossomo().equals(pais.get(1).getCromossomo())){
                x++;
            }
            else{
                i = 0;
                candidatosPais1.clear();
                candidatosPais2.clear();
                pais.clear();
            }
        }
        return pais;
    }
    
    
    // MUTAÇÃO MUITO FORTE, POIS PODE OCORRER EM TODOS OS GENES
    public static void mutacao(Individuo ind, double txMutacao){
        Random gerador = new Random();
        String palavra = ind.getCromossomo();        
        String aux = null, inicio = null, fim = null;
        for(int i=0;i<palavra.length();i++){
            if((Math.random()*100) < txMutacao){
                aux = palavra.substring(i, i+1);                
                
                if(aux.equals("0"))
                    aux="1";
                else
                    aux="0";
                
                inicio=palavra.substring(0,i);
                fim=palavra.substring(i+1, palavra.length());
                palavra=inicio+aux+fim;
            }
        }
        ind.setCromossomo(palavra);
    }
    
    
    // MUTAÇÃO FRACA OCORRE DE ACORDO COM O QUE COLOCAR COMO ESTÁTICO
    public static void mutacao1(Individuo ind, double txMutacao){
        
        int qtdVezes = 3;//quantdade de gens que muda em toda a string
        int aux;
        String aux2;
        Random gerador = new Random();
        String palavra = ind.getCromossomo(); 
        if((Math.random()*100) < txMutacao){
            for(int x = 0; x < qtdVezes; x++){
                aux = gerador.nextInt(palavra.length());
                aux2 = ind.getCromossomo().substring(aux, aux+1);
                if(aux2.equals("1")){
                    StringBuilder sb = new StringBuilder(ind.getCromossomo());
                    sb.setCharAt(aux, '0');
                    ind.setCromossomo(sb.toString());
                }else{
                    StringBuilder sb = new StringBuilder(ind.getCromossomo());
                    sb.setCharAt(aux, '1');
                    ind.setCromossomo(sb.toString());
                }
            }
        }
    }
}
