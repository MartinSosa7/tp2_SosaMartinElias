package ar.edu.unju.fi.ejercicio03.constantes;

public enum Provincia {

		JUJUY(811611,53219d), 
		SALTA(1441351,155488d), 
		TUCUMAN(1687305,22524d), 
		CATAMARCA(429562,102602d), 
		LA_RIOJA(383865,89680d), 
		SANTIAGO_DEL_ESTERO(896461,136351d);
	
		private Integer population;
		private Double surface;
		
		private Provincia(Integer population, Double surface) {
			this.population = population;
			this.surface = surface;
		}


		public Integer getPopulation() {
			return population;
		}


		public void setPopulation(Integer population) {
			this.population = population;
		}


		public Double getSurface() {
			return surface;
		}


		public void setSurface(Double surface) {
			this.surface = surface;
		}



		public double calculatePopulationDensity() {
			return (double) this.population/this.surface;
		}
		
		
		
}
