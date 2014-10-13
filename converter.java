import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class converter {
	public static void main(String args[]) {
		Persona aux= new Persona();
		try{
			//Manejo de la respuesta
			int indice = 0;
			int indiceFin = 0;
			// Abrimos el archivo
			List<Persona> funcionarios = new ArrayList<Persona>();
			String fileDir="nomina_administrativos_lista";
			InputStreamReader entrada = new InputStreamReader(new FileInputStream(fileDir), "UTF-8");
			BufferedReader buffer = new BufferedReader(entrada);
			String strLinea;
			// Leer el archivo linea por linea
			int con=0;
			    while ((strLinea = buffer.readLine()) != null)   {
				// Imprimimos la línea por pantalla
				if(strLinea.contains("<td class=\"text-min\" style=\"text-align:")){
			    		con++;
					indice = strLinea.indexOf(">");
			    		indiceFin = strLinea.indexOf("<",strLinea.indexOf("<")+1);
			    		if(con==1){
			    			aux= new Persona();
			    			aux.setAnho(strLinea.substring(indice+1, indiceFin));
			    		}if(con==2){
			    			aux.setMes(strLinea.substring(indice+1, indiceFin));
			    		}if(con==3){
			    			aux.setCedula(strLinea.substring(indice+1, indiceFin));
			    		}if(con==4){
							aux.setNombre(strLinea.substring(indice+1, indiceFin));
			    		}if(con==5){
		    					aux.setCategoriaPago(strLinea.substring(indice+1, indiceFin));
			    		}if(con==6){
								aux.setTipoFuncionario(strLinea.substring(indice+1, indiceFin));
					}if(con==7){
								aux.setAntiguedad(strLinea.substring(indice+1, indiceFin));
					}
					if(con==8){
						aux.setSalario(strLinea.substring(indice+1, indiceFin).replaceAll(",","").trim());
						con=0;
						funcionarios.add(aux);
					}
			    	}
			    }
			    // Cerramos el archivo
			    entrada.close();
			    writeToCSV(funcionarios);
		}catch (Exception e){ //Catch de excepciones
		    e.printStackTrace();
		}
    }
    private static final String CSV_SEPARATOR = ",";
    private static final String CSV_DELIMITATOR = "\"";
    private static void writeToCSV(List<Persona> list)
    {
	try
	{
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("funcionarios.csv"), "UTF-8"));
	    StringBuffer oneLine = new StringBuffer();
	    oneLine.append(CSV_DELIMITATOR);
	    oneLine.append("Año");
	    oneLine.append(CSV_DELIMITATOR);
	    oneLine.append(CSV_SEPARATOR);
	    oneLine.append(CSV_DELIMITATOR);
	    oneLine.append("Mes");
	    oneLine.append(CSV_DELIMITATOR);
	    oneLine.append(CSV_SEPARATOR);
	    oneLine.append(CSV_DELIMITATOR);
	    oneLine.append("Cedula");
	    oneLine.append(CSV_DELIMITATOR);
	    oneLine.append(CSV_SEPARATOR);
	    oneLine.append(CSV_DELIMITATOR);
	    oneLine.append("Nombre");
	    oneLine.append(CSV_DELIMITATOR);
	    oneLine.append(CSV_SEPARATOR);
	    oneLine.append(CSV_DELIMITATOR);
	    oneLine.append("Categoria de Pago");
	    oneLine.append(CSV_DELIMITATOR);
	    oneLine.append(CSV_SEPARATOR);
	    oneLine.append(CSV_DELIMITATOR);
	    oneLine.append("Tipo de Funcionario");
	    oneLine.append(CSV_DELIMITATOR);
	    oneLine.append(CSV_SEPARATOR);
	    oneLine.append(CSV_DELIMITATOR);
	    oneLine.append("Antiguedad");
	    oneLine.append(CSV_DELIMITATOR);
	    oneLine.append(CSV_SEPARATOR);
	    oneLine.append(CSV_DELIMITATOR);
	    oneLine.append("Salario");
	    oneLine.append(CSV_DELIMITATOR);
	    bw.write(oneLine.toString());
	    bw.newLine();
	    for (Persona persona : list)
	    {
	        oneLine = new StringBuffer();
	        oneLine.append(CSV_DELIMITATOR);
	        oneLine.append(persona.getAnho());
	        oneLine.append(CSV_DELIMITATOR);
	        oneLine.append(CSV_SEPARATOR);
	        oneLine.append(CSV_DELIMITATOR);
	        oneLine.append(persona.getMes());
	        oneLine.append(CSV_DELIMITATOR);
	        oneLine.append(CSV_SEPARATOR);
	        oneLine.append(CSV_DELIMITATOR);
	        oneLine.append(persona.getCedula());
	        oneLine.append(CSV_DELIMITATOR);
	        oneLine.append(CSV_SEPARATOR);
	        oneLine.append(CSV_DELIMITATOR);
	        oneLine.append(persona.getNombre());
	        oneLine.append(CSV_DELIMITATOR);
	        oneLine.append(CSV_SEPARATOR);
	        oneLine.append(CSV_DELIMITATOR);
	        oneLine.append(persona.getCategoriaPago());
	        oneLine.append(CSV_DELIMITATOR);
	        oneLine.append(CSV_SEPARATOR);
	        oneLine.append(CSV_DELIMITATOR);
	        oneLine.append(persona.getTipoFuncionario());
	        oneLine.append(CSV_DELIMITATOR);
	        oneLine.append(CSV_SEPARATOR);
	        oneLine.append(CSV_DELIMITATOR);
	        oneLine.append(persona.getAntiguedad());
	        oneLine.append(CSV_DELIMITATOR);
	        oneLine.append(CSV_SEPARATOR);
	        oneLine.append(CSV_DELIMITATOR);
	        oneLine.append(persona.getSalario());
	        oneLine.append(CSV_DELIMITATOR);
	        bw.write(oneLine.toString());
	        bw.newLine();
	    }
	    bw.flush();
	    bw.close();
	}
	catch (UnsupportedEncodingException e) {}
	catch (FileNotFoundException e){}
	catch (IOException e){}
    }
	
}


