import java.util.Scanner;
import java.text.*;
import java.util.*;

/**
 *
 * Eduarda Vitória e Stefany Tam
 * 
 * TRABALHO PRÁTICO 04: Construir a classe Data, conforme especificação abaixo,
 * este exercício comporá a avaliação final, portanto será obrigatória sua
 * elaboração para a prova final.
 
 * - O construtor Data() deverá permitir ao usuário digitar os valores de dia, mês e ano e com eles inicializar os atributos da classe. Os valores digitados deverão ser consistidos e só aceitos se válidos, caso contrário, redigitar;
 * - O construtor Data(int d, int m, int a) deverá receber os valores de dia, mês e ano e com eles inicializar as propriedades da classe;
 * - Os métodos entraDia(int d), entraMes(int m) e entraAno(int a) devem receber um valor e atribuí-lo às respectivas propriedades;
 * - Os métodos entraDia (),entraMes () e entraAno () devem permitir ao usuário digitar um valor e atribuílo a respectiva propriedade. Os valores digitados devem sofrer consistência e só aceitos quando válidos, caso contrário, solicitar ao usuário redigitar;
 * - Os métodos retDia(), retMes() e retAno() devem nos devolver as respectivas propriedades;
 * - O método mostra1() deve nos devolver a data no formato: dd/mm/aaaa;
 * - O método mostra2() deve nos devolver a data no formato: dd/mesPorExtenso/ano;
 * - O método bissexto() deve nos devolver um boolean informando se o ano é ou não bissexto;
 * - O método diasTranscorridos, deve retornar a quantidade de dias transcorridos no ano até a data digitada.
 * - O método apresentaDataAtual() deve imprimir a data atual, utilizando as classes Date e DateFormat, o DateFormat empregando o seguinte método: getDateInstance(DateFormat.FULL);
 * - Conveniente colocar tratamento de exceção para as possíveis inconsistências na entrada de dados.
 */
public class Data {
	Scanner scan = new Scanner(System.in);
	private int dia = 0;
	private int mes = 0;
	private int ano = 0;

	public Data() {

		do {
			System.out.print("Dia: ");
			dia = scan.nextInt();
		} while (dia > 31 || dia <= 0);
		do {
			System.out.print("Mes: ");
			mes = scan.nextInt();
		} while (mes > 12 || mes <= 0);
		do {
			System.out.print("Ano: ");
			ano = scan.nextInt();
		} while (ano > 2022 || ano <= 0);
	}

	public Data(int d, int m, int a) {
		this.dia = d;
		this.mes = m;
		this.ano = a;

	}

	public void entraDia(int d) {
		this.dia = d;

	}

	public void entraMes(int m) {
		this.mes = m;
	}

	public void entraAno(int a) {
		this.ano = a;
	}

	public void entraDia() {
		do {
			System.out.print("Dia: ");
			dia = scan.nextInt();
		} while (dia > 30 || dia <= 0);

	}

	public void entraMes() {
		do {
			System.out.print("Mes: ");
			mes = scan.nextInt();
		} while (mes > 12 || mes <= 0);

	}

	public void entraAno() {
		do {
			System.out.print("Ano: ");
			ano = scan.nextInt();
		} while (ano <= 0);

	}

	public int retDia(int dia) {
		return dia;
	}

	public int retMes(int mes) {
		return mes;
	}

	public int retAno(int ano) {
		return ano;
	}

	public String mostra1() {
		String formatoHora;
		formatoHora = (this.dia + "/" + this.mes + "/" + this.ano);
		System.out.println("--------------");
		System.out.println(formatoHora);
		System.out.println("--------------");
		return formatoHora;
	}
	
	public String mostra2() {
		String mesPorExtenso = null;
		switch (this.mes) {
		case 1:
			mesPorExtenso = "Janeiro";
			break;
		case 2:
			mesPorExtenso = "Fevereiro";
			break;
		case 3:
			mesPorExtenso = "Março";
			break;	
		case 4:
			mesPorExtenso = "Abril";
			break;	
		case 5:
			mesPorExtenso = "Maio";
			break;
		case 6:
			mesPorExtenso = "Junho";
			break;
		case 7:
			mesPorExtenso = "Julho";
			break;
		case 8:
			mesPorExtenso = "Agosto";
			break;
		case 9:
			mesPorExtenso = "Setembro";
			break;
		case 10:
			mesPorExtenso = "Outubro";
			break;
		case 11:
			mesPorExtenso = "Novembro";
			break;
		case 12:
			mesPorExtenso = "Dezembro";
			break;
		}
		System.out.println(this.dia + "/" + mesPorExtenso + "/" + this.ano);
		System.out.println("--------------");
		return mesPorExtenso;
	}

	public boolean bissexto() {
		return (this.ano % 4 == 0) && (this.ano % 100 != 0 || this.ano % 400 == 0);
	}
	
    public int diasTranscorridos() {
    	 int qtdDias = 0;

         for (int mes = 1; mes < this.mes; mes++) {
             qtdDias += qtdDiasNoMes(mes);
         }

         qtdDias += (this.dia - 1);
         System.out.println("Dias transcorridos: " + qtdDias);
         System.out.println("--------------");
         return qtdDias;  
    }
    
    private int qtdDiasNoMes(int numMes){
        int[] qtdDiasMes = new int[]{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if(this.bissexto()){
            qtdDiasMes[1] = 29;
        }

        return qtdDiasMes[numMes - 1];
    }
    
    public void apresentaDataAtual() {
        Date data = new Date();
        System.out.println("Data atual: " + DateFormat.getDateInstance(DateFormat.FULL).format(data));
        System.out.println("--------------");
    }
}
