---

# IE-InterfacesGraficas

---

## 📌 INTEGRANTES

Barreiro --> Clase Armas y respectivas subclases

Gerhauser --> Clase Historial y Main

Noriega --> Clase Personaje

Periotti --> Clase Habilidad y respectivas subclases

Sampo --> Clase Villano

Signorile --> Clase Heroe

Valinotti --> Clase Batalla

---

## 📌 INSTRUCCIONES DE JUEGO

1. **Ingreso de datos iniciales**
   1. Ingresa los atributos del **Héroe**:
      1. Salud (**entero**, cantidad de vida).  
      2. Defensa (**entero**, reduce daño recibido).  
      3. Ataque (**entero**, daño infligido).  
      4. Apodo (**texto entre 3 y 10 caracteres, solo letras y espacios**).  
   2. Ingresa los atributos del **Villano**:
      1. Salud (**entero**, cantidad de vida).  
      2. Defensa (**entero**, reduce daño recibido).  
      3. Ataque (**entero**, daño infligido).    
      4. Apodo (**texto entre 3 y 10 caracteres, solo letras y espacios**).  

2. **Batalla por turnos**
   1. Una vez cargados los datos, la pelea comienza automáticamente.  
   2. Presiona **Enter** para avanzar cada turno.  
   3. En cada turno:
      - El **Héroe** ataca al **Villano**.  
      - El **Villano** responde con un contraataque.  
   4. La batalla continúa hasta que uno de los dos llegue a **0 de salud**.  

3. **Final de la batalla**
   1. El programa anunciará quién ganó.  
   2. Luego te preguntará:  
      ```
      Desea jugar de nuevo????Ingrese 1(Si) o 0 (No) :
      ```
   3. Si respondes **"si"**, se reinicia el juego y deberás ingresar nuevamente los datos.  
   4. Si respondes **"no"**, el juego mostrará un mensaje de despedida y finalizará.  

---

## 📌 Notas importantes
- Ingresa solo **números enteros** para salud, defensa y ataque.  
- El **apodo debe tener entre 3 y 10 caracteres, y solo puede contener letras y espacios**.  
- El ganador será quien logre reducir la salud del oponente a 0.  

---

## 📌 EJEMPLO

### DATOS
<img width="516" height="225" alt="image" src="https://github.com/user-attachments/assets/51e40132-8012-4031-9cfd-41c66796d7f1" />

### COMIENZO DE LA BATALLA
<img width="457" height="234" alt="image" src="https://github.com/user-attachments/assets/feb7f4f8-89af-4c94-9f57-7b1caf116100" />

### FIN DE LA BATALLA
<img width="570" height="270" alt="image" src="https://github.com/user-attachments/assets/533d5f73-329c-48cb-9bcf-77cb8da4d7c2" />

### REPORTE E HISTORIAL DE LA BATALLA
<img width="544" height="330" alt="image" src="https://github.com/user-attachments/assets/1f68184c-5c9d-4118-97db-13b63a4a116a" />


---

## 📌 PROMPTS UTILIZADOS

PROMPTS EN ETAPA DE ANALISIS
https://chatgpt.com/share/68d8a54c-c984-8008-90fc-7b8ea77641bc

HISTORIAL
https://chatgpt.com/share/68d8a4d7-f334-8000-bf6b-742f0353962f

ARMAS
https://chatgpt.com/share/68d956f1-aae0-8008-a72b-2dd14f85b228

HEROE
Necesito que me guíes para implementar la subclase Heroe que hereda de Personaje en un proyecto Java (NetBeans). La clase Personaje ya existe con estos atributos públicos: - String apodo - int salud - int defensa - int bendicion - String arma - String habilidad - int ataque Y tiene métodos abstractos: - public abstract void invocarArma(); - public abstract void cargarBendicion(); - public abstract void cargarHabilidad(String habilidad); ¿Cómo debería escribir mi clase Heroe para: 1) Implementar esos tres métodos. 2) Incluir un constructor que llame a super. 3) Tener un ataque especial llamado usarCastigoBendito (que haga más daño y cure un porcentaje). 4) Poder curarse y activar una defensa temporal (defensaExtra por algunos turnos). 5) Incluir un método defensaActual() propio del héroe que tenga en cuenta esa defensaExtra.

VILLANO
Estoy desarrollando un proyecto en Java con una clase abstracta Personaje. Necesito que la subclase Villano tenga un sistema de ataque especial: que invoque armas según el porcentaje de bendición, que pueda evolucionarlas con distintos umbrales, y que al llegar al 100% cargue una habilidad suprema llamada Leviatán del Vacío. También quiero que el ataque pueda tener probabilidad de crítico y que incremente la bendición después de cada turno. ¿Cómo debería estructurar la lógica y el flujo del ataque para que se entienda bien en el código?

PERSONAJE
<img width="336" height="47" alt="image" src="https://github.com/user-attachments/assets/edff6020-f179-478f-a124-3c15ff2fddab" />
<img width="526" height="179" alt="image" src="https://github.com/user-attachments/assets/7dbfa133-3747-488a-8825-9eca1bc8a3ee" />

