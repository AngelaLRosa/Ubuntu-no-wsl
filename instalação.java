package projeto;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class instalação {

	public static void main(String[] args) {
		 try {
	            // Atualizando os pacotes do sistema
	            System.out.println("Atualizando pacotes do sistema...");
	            runCommand("sudo apt update ");

	            // Instalando o Nginx
	            System.out.println("Instalando o Nginx...");
	            runCommand("sudo apt install nginx ");

	            // Iniciando o Nginx
	            System.out.println("Iniciando o Nginx...");
	            runCommand("service  nginx start");

	            // Verificando status do Nginx
	            System.out.println("Verificando status do Nginx...");
	            runCommand("service nginx status");

	            // Permitir tráfego HTTP e HTTPS no firewall (ufw)
	            System.out.println("Configurando o firewall para permitir tráfego HTTP e HTTPS...");
	            runCommand("sudo ufw allow 'Nginx Full'");

	            System.out.println("Instalação do Nginx concluída com sucesso!");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    private static void runCommand(String command) throws Exception {
	        ProcessBuilder processBuilder = new ProcessBuilder();
	        processBuilder.command("bash", "-c", command);
	        Process process = processBuilder.start();

	        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            System.out.println(line);
	        }

	        int exitCode = process.waitFor();
	        if (exitCode == 0) {
	            System.out.println("Comando executado com sucesso: " + command);
	        } else {
	            System.out.println("Erro ao executar o comando: " + command);
	        }
	
	}

}
