import CartaoVendas from "./componentes/cartaoVendas";
import Header from "./componentes/header";

function App() {
    return(
      <>
        <Header/>
        <main>
            <section id="sales">
              <div className="dsmeta-container">
                  <CartaoVendas/>
              </div>
            </section>
        </main>
      </>
    )
}

export default App;
//Quando for usar mais de um elemento na mesma função precisa abrir <> e fechar com </>