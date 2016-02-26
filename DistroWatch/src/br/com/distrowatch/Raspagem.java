package br.com.distrowatch;

import java.io.IOException; // Only needed if scraping a local File.
import java.util.LinkedHashMap;
import java.util.LinkedList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 * @author helen {@link} http://www.geog.leeds.ac.uk/courses/other/programming/
 *         practicals/general/web/scraping-intro/2.html
 */
public class Raspagem {

	private static Elements doc = null;
	private static Elements tr = null;

	public static LinkedHashMap<String, String> getDadosDistroWatch(String versao) {

		LinkedHashMap<String, String> dados = new LinkedHashMap<String, String>();

		try {

			String url = "http://distrowatch.com/table.php?distribution=" + versao;
			doc = Jsoup.connect(url).get().getAllElements();
			Elements table = doc.tagName("table");
			Elements tbody = table.tagName("tbody");
			tr = tbody.tagName("tr");
			
			for (Element row : tr) {

				Elements trBack = row.tagName("tr").getElementsByClass("Background");

				for (Element element : trBack) {

					Elements thBack = element.tagName("th").getElementsByClass("Info");

					if (thBack.size() > 1) {
						dados.put(thBack.get(0).text(), thBack.get(1).text());
					}

				}

			}

			return dados;
		}

		catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
		}
	}

	public static LinkedHashMap<String, String> getCabecalhoDistroWatch() {
		Elements tableTitle = tr.get(0).tagName("td").getElementsByClass("TablesTitle");
		LinkedHashMap<String, String> cabecalho = new LinkedHashMap<String, String>();
		if (tableTitle.size() > 0) {

			Element thBack = tableTitle.get(0).tagName("ul");
			Elements thli = thBack.getElementsByTag("tr");

			for (Element element : thli) {
				if (element.text().contains(": ")) {
					String[] cabecalhoTratado = element.text().split(":");

					if (cabecalhoTratado.length == 2) {
						cabecalho.put(cabecalhoTratado[0].trim(), cabecalhoTratado[1].trim());
					}

				}
			}
			
		}

		return cabecalho;
	}

	public static void main(String args[]) {

		getDadosDistroWatch("ubuntu");

	}

}
