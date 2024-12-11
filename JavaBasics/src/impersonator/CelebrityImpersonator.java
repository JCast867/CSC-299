package impersonator;

/**
 * @author <Jaime Castaneda>
 */
public class CelebrityImpersonator 
{
    public String generateQuote(String quote, String generatorName) 
    
    {
    	
    	
    	if (generatorName == "Canadian") {
    		quote = quote + ", eh?";
    	} else if (generatorName == "Valley Girl") {
    		return "like Four like score like and like seven like years like ago";
    	} else if (generatorName == "Shatner") {
    		quote = "Four...\nscore...\nand...\nseven...\nyears...\nago...\n";
    	} else if (generatorName == "Pirate") {
    		quote = "FouRRRr scoRRRre and seven yeaRRRrs ago";
    	} else if (generatorName == "Zatanna") {
    		quote = "ruoF erocs dna neves sraey oga";
    	} else if (generatorName == "Yoda") {
    		quote = "score Four seven and ago years";
    	}
        return quote;
    }
}
