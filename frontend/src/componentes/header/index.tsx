import icone from '../../assets/img/logo.svg'
import './styles.css'

function Header() {
    return(
        <header>
        <div className="dsmeta-logo-container">
            <img src={icone}  alt="Logo DSMeta"/>
            <h1>DSMeta</h1>
            <p>Desenvolvido por <a href="https://www.linkedin.com/in/gustavo-henrique-java/">Gustavo Henrique</a>, na semana Semana Spring React ofertada pela <a href="https://devsuperior.com.br/">@devsuperior.ig</a>.</p>
        </div>
    </header>
    )
}

export default Header