Import java.util.Scanner;
public catalogue program{
    Scanner console =new Scanner(System.in)
ItemDelMEnu[]principal=new ItemDelMEnu
new InserirAnimal(),
new ListarAnimal(),
new SAida()
};
do{
for(in i= 0;i) < principal.length; i++){
System.out.println(i + " - " + principal[i].getDescricao());
}
System.out.print("Qual opção desejada");
int opção = Integer.parserInt(console.nexline());
principal[opção].executar();
} while (!sair);