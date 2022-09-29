package Parte3_Exercicio06_Estatistica_Pag167;

public class Estatistica {
	

		// atributo
		private double[] valores;

		// construtores
		public Estatistica() {
		}

		public Estatistica(double[] valores) {
			this.valores = valores;
		}

		// getters e setters
		public void setValores(double[] valores) {
			this.valores = valores;
		}

		public double[] getValores(double[] dados) {
			return valores;
		}

		// m�todos pr�prios
		public void ordena() {
			mergeSort(valores,valores.length);
		}

		public void mergeSort(double[] a, int n) {
			if (n < 2) {
				return;
			}
			int mid = n / 2;
			double[] l = new double[mid];
			double[] r = new double[n - mid];

			for (int i = 0; i < mid; i++) {
				l[i] = a[i];
			}
			for (int i = mid; i < n; i++) {
				r[i - mid] = a[i];
			}
			mergeSort(l, mid);
			mergeSort(r, n - mid);

			merge(a, l, r, mid, n - mid);
		}

		public void merge(double[] a, double[] l, double[] r, int left, int right) {
			int i = 0, j = 0, k = 0;
			while (i < left && j < right) {
				if (l[i] <= r[j]) {
					a[k++] = l[i++];
				} else {
					a[k++] = r[j++];
				}
			}
			while (i < left) {
				a[k++] = l[i++];
			}
			while (j < right) {
				a[k++] = r[j++];
			}
		}

		public double media() {
			double soma= 0.0;
			for(double balde:valores) {
				soma += balde;
			}
			return soma / valores.length;
		}

		public double moda() {
			int j=0;
			double m [][] = new double[valores.length][2];
			for(int i=0; i<valores.length; i++) {
				if(i==0) {
					m[j][0] = valores[i];
					m[j][1] ++;
				}
				else {
					if(valores[i]==valores[i-1]) {
						m[j][1] ++;
					} else {
						j++;
						m[j][0] = valores[i];
						m[j][1] ++;
					}
				}
			}
			
			double valor = m[0][0];
			double maiorQtde = m[0][1];
			
			for(int i=0; i<m.length; i++) {
				if(m[i][1] > maiorQtde) {
					valor = m[i][0];
					maiorQtde = m[i][1];
				}
			}
			
			return valor;
		}

		public double mediana() {
			int len = valores.length;
			
			if(valores.length%2==0) {
				return (valores[len/2-1]+valores[len/2])/2.0;
			}
			return valores[len/2];
		}

		public double variancia() {
			double media = media();
			double var = 0.0;
			for(double balde:valores) {
				var += Math.pow(media-balde,2);
			}
			return var;
		}

		public double desviopadrao() {
			return Math.sqrt(variancia());
		}
		
		public Object imprimeValores() {
			for(double balde:valores) {
				System.out.print(balde+ " - ");
			}
			return valores;
			
		}
		
		public void valoresDesordenados(double[] dados) {

			double repo = 0.0;
			for (double balde: dados){
				return repo;
				
			}
		}
	}
