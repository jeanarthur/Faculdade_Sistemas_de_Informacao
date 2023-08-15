public class Main {

    public static void main(String[] args) {
        Funcionario dev1 = new Funcionario(Cargo.DESENVOLVEDOR, 2000);
        Funcionario dev2 = new Funcionario(Cargo.DESENVOLVEDOR, 3500);
        Funcionario dba1 = new Funcionario(Cargo.DBA, 1000);
        Funcionario dba2 = new Funcionario(Cargo.DBA, 2000);
        Funcionario tester1 = new Funcionario(Cargo.TESTER, 1000);
        Funcionario tester2 = new Funcionario(Cargo.TESTER, 2000);

        Calculadora calculadora = new Calculadora();

        System.out.println(calculadora.calcularSalario(dev1));
        System.out.println(calculadora.calcularSalario(dev2));
        System.out.println(calculadora.calcularSalario(dba1));
        System.out.println(calculadora.calcularSalario(dba2));
        System.out.println(calculadora.calcularSalario(tester1));
        System.out.println(calculadora.calcularSalario(tester2));

    }

}
