package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	private String getOs() {
		return System.getProperty("os.name");
	}
	
	private String readProcess(String process) {
		StringBuffer strBuffer = new StringBuffer();
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader reader = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(reader);
			String linha = buffer.readLine();
			while (linha != null) {
				strBuffer.append(linha + "\n");
				linha = buffer.readLine();				
			}			
			buffer.close();
			reader.close();
			fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strBuffer.toString();
	}
	
	public String ip() {
		StringBuffer retorno = new StringBuffer();
		if(getOs().contains("Windows")) {
			String resposta = readProcess("ipconfig");
			String adaptadores[] = resposta.split("Adapt"); 
			for(String adap: adaptadores) {
				if(adap.contains("IPv4")) {
					String linhasAdaptador[] = adap.split("\n");
					retorno.append("Adapt"+linhasAdaptador[0]);
					for(String linhaAtual:linhasAdaptador) {
						if(linhaAtual.contains("IPv4")) {
							String splitIpv4[] = linhaAtual.split(":");
							retorno.append(splitIpv4[splitIpv4.length-1]+"\n");
						}
					}
				}				
			}
		}else {
			System.out.println("Tux");
		}
		return retorno.toString();
	}
	
	public String ping() {
		String retorno = "";
		if(getOs().contains("Windows")) {
			String resposta = readProcess("ping -4 -n 10 www.google.com.br");
			String resultados[] = resposta.split("=");
			retorno = ("Ping:"+resultados[resultados.length-1]);
		}else {
			System.out.println("Tux");
		}
		return retorno;
	}
}
