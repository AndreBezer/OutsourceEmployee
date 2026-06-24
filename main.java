import java.util.Scanner;

public class main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite a quantidade de usuarios a serem cadastrados: ");
		int qtd = sc.nextInt();

		Employee[] listaFuncionarios = new Employee[qtd];

		for (int i = 0; i < listaFuncionarios.length; i++){
			System.out.printf("\n\nDigite o nome do " + (i+1) + " funcionario: ");
			String nome = sc.next();

			System.out.print("Digite a quantidade de horas do funcionario " + nome + ": ");
			int hour = sc.nextInt();

			System.out.print("Digite o valor por hora do funcionario " + nome + ": ");
			double valorPorHora = sc.nextDouble();

			System.out.print("O funcionario eh terceirizado? ");
			String opc = sc.next();

			if (opc.equals("s")){
				System.out.print("Digite o custo adicional do funcionario:");
				double custo = sc.nextDouble();

				listaFuncionarios[i] = new OutsourceEmployee(nome, hour, valorPorHora, custo);
			}

			else{
				listaFuncionarios[i] = new Employee(nome, hour, valorPorHora);
			}

		}

		System.out.println("\n\n");

		for(int i = 0; i < listaFuncionarios.length; i++){
			System.out.println(listaFuncionarios[i].getName() + " ---===--- " + listaFuncionarios[i].payment());
		}

		sc.close();
	}

	// CLASSE Employee
	public static class Employee{

		// variaveis
		protected String name;
		protected Integer hour;
		protected Double valuePerHour;
		
		// COntrutores
		public Employee(){}

		public Employee(String name, Integer hour, Double valuePerHour){
			this.name = name;
			this.hour = hour;
			this.valuePerHour = valuePerHour;
		}

		// get & set
		public String getName(){
			return name;
		}

		public void setName(String name){
			this.name = name;
		}

		public Integer getHour(){
			return hour;
		}

		public void setHour(Integer hour){
			this.hour = hour;
		}

		public Double getValuePerHour(){
			return valuePerHour;
		}

		public void setValuePerHour(Double valuePerHour){
			this.valuePerHour = valuePerHour;
		}

		public Double payment(){
			return hour * valuePerHour;
		}
	}
	
	// CLASSE Outsource Employee filha de Employee
	public static final class OutsourceEmployee extends Employee{
		private Double additionalCharge;

		public Double getAdditionalCharge(){
			return additionalCharge;
		}

		public void setAdditionalCharge(Double additionalCharge){
			this.additionalCharge = additionalCharge;
		}

		public OutsourceEmployee(){}

		public OutsourceEmployee(String name, Integer hour, Double valuePerHour, Double additionalCharge){
			super(name, hour, valuePerHour);
			this.additionalCharge = additionalCharge;
		}
	
		@Override
		public final Double payment(){
			return super.payment() + additionalCharge * 1.1; 
		}
	}
}
