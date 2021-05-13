package br.unicesumar.aula20210513.vigências;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class AppVigências {
	
	
	public static void main(String[] args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		
		Date vinculadoEm = sdf.parse("01/07/2007");
		Date vinculadoAté = sdf.parse("01/06/2021");
		
		String dataInformadaComoString = JOptionPane.showInputDialog("Digite uma data");
		System.out.println(dataInformadaComoString);
		try {
			Date dataInformadaComoDate = sdf.parse(dataInformadaComoString);
			System.out.println(dataInformadaComoDate.toLocaleString());
			if (validarNovoVínculo(vinculadoEm, vinculadoAté, dataInformadaComoDate)) {
				System.out.println("Opa, vínculo ok!");
			} else {
				System.out.println("Eita, vínulo inválido!");
			}
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Opa, data inválida! [" + dataInformadaComoString + "]" );
		}
	}

	private static boolean validarNovoVínculo(Date vinculadoEm, Date vinculadoAté, Date novaDataParaVínculo) {
		return (novaDataParaVínculo.compareTo(vinculadoEm) == -1 || novaDataParaVínculo.compareTo(vinculadoAté) == 1); 
	}

}









