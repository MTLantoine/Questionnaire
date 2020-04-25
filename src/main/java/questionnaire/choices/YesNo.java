package questionnaire.choices;

public enum YesNo implements Choices {
	
	/**
	 * 
	 * the "oui" answer
	 */
	OUI {
		@Override
		public String toString() {
	        return "oui";
	    }

		@Override
		/**
		 * 
		 * @param proposition the proposition the user made
		 * @return <code>true</code> if the proposition is in the choices enum, <code>false</code> else
		 */
		public boolean isIn(String proposition) {
			return (this.toString().equals(proposition.toLowerCase()));
		}
	},
	
	/**
	 * 
	 * the "non" answer
	 */
	NON {
		@Override
		public String toString() {
	        return "non";
	    }

		@Override
		/**
		 * 
		 * @param proposition the proposition the user made
		 * @return <code>true</code> if the proposition is in the choices enum, <code>false</code> else
		 */
		public boolean isIn(String proposition) {
			return (this.toString().equals(proposition.toLowerCase()));
		}
	}

}
