# Documentation

## `public static void main(String[] args)`

Metode principal, s'executa al iniciar l'aplicacio

 * **Parameters:** `args` — arguments introduits al iniciar la aplicacio

## `private static void mostarMenuPreBatalla()`

Mostra el menu anterior a una batalla per pantalla

## `private static void batalla()`

Mostra el menu de batalla per pantalla

## `private static void atacar()`

executa una ronda d'atacs

## `private static void mostrarStats()`

Mostra per pantalla els stats del jugador

## `private static void mostrarStatsEnemic()`

Mostra per pantalla els stats de l'enemic

## `public static Enemic seleccionarEnemic()`

Crea un enemic amb els estats indicats per l'usuari

 * **Returns:** Enemic Retorna l'enemic generat

## `public static Objecte seleccionarObjecte()`

Permet al usuari seleccionar un objecte del seu inventari

 * **Returns:** Objecte Objecte seleccionat

## `public static double preguntarNumero(int min, int max, boolean zero)`

Pregunta a l'usuari un numero entre un minim i un maxim

 * **Parameters:**
   * `min` — el numero minim que l'usuari pot introduir
   * `max` — el numero maxim que l'usuari pot introduir
   * `zero` — indica si s'accepta el numero zero, inclus si esta fora del rang
 * **Returns:** double retorna el numero introduit per l'usuari

## `public static double preguntarStat(String nom)`

pregunta a l'usuari el valor d'un stat

 * **Parameters:** `nom` — nom del stat que es vol preguntar
 * **Returns:** double retorna el valor al stat introduit

## `public static void pause()`

pausa l'execucio del programa fins que l'usuari premi enter

## `public static void clearScreen()`

Esborra el contingut de la pantalla

## `private static int getRandomNumberInRange(int min, int max)`

Genera un numero aleatori entre el rang introduit

 * **Parameters:**
   * `min` — numero minim que es pot generar
   * `max` — numero maxim que es pot generar
 * **Returns:** int numero generat

## `public static Objecte generarObjecteAleatori()`

Genera un objecte aleatoriament

 * **Returns:** Objecte objecte generat

## `public static void AfeigirObjecteAplicat(Objecte objecte)`

afegeix un objecte a la llista d'objectes utilitzats d'urant una ronda amb l'objectiu de retirar els efectes a la seguent ronda

 * **Parameters:** `objecte` — objecte que es vol afeigir a la llista

## `public static void esborrarStatsAplicats()`

resta els estats aplicats al personatge per encanteris durant la ronda anterior
