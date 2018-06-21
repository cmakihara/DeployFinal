package br.casa.email;

import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import br.casa.agendaapi.model.Contato;
import br.casa.agendaapi.model.ItemPedido;
import br.casa.agendaapi.model.Pedido;
import br.casa.agendaapi.model.Usuario;
import br.casa.agendaapi.repository.ContatoRepository;
import br.casa.agendaapi.repository.PedidoRepository;
import br.casa.agendaapi.repository.UsuarioRepository;

public class EnviarEmail {
	
	private Session session;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ContatoRepository contatoRepository;
	
	public EnviarEmail() {
	    Properties props = new Properties();
	    
	    /** Parâmetros de conexão com servidor Gmail */
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "465");
	    

	    session = Session.getDefaultInstance(props,
	                new javax.mail.Authenticator() {
	                     protected PasswordAuthentication getPasswordAuthentication() 
	                     {
	                           return new PasswordAuthentication("emailprojeto123@gmail.com", "projetox123%");
	                     }
	                });

	    /** Ativa Debug para sessão */
	    session.setDebug(true);
	    
		
	}
	
	public void enviarParaCliente(List<ItemPedido> itens) {
		ItemPedido item1 = itens.get(0);
		
		Pedido pedido = item1.getPedido();
		
		Contato cliente = pedido.getContato();
		
		try {
		//email para o cliente
        Message message2 = new MimeMessage(session);
        
        StringBuilder sb = new StringBuilder();
        sb.append("\nOlá ");
        sb.append(cliente.getNomeFantasia());
        
        sb.append("Empresa: ");
        sb.append(cliente.getRazaoSocial());
        sb.append("\nNome Fantasia: ");
        sb.append(cliente.getNomeFantasia());
        sb.append("\nCNPJ: " +  cliente.getCnpj());
        sb.append("\n\n════════════════════════════════════════════════════════════");
        sb.append("\n\nInformações do orçamento:\n\n");
        sb.append("Orçamento n°: ");
        sb.append(pedido.getId_pedido());
        sb.append("\n\nProdutos:\n");
        
        for (ItemPedido item : itens) {
			sb.append(item.getProduto().getNomeproduto());
			sb.append("     Quantidade: ");
			sb.append(item.getQuantidade());
			sb.append("     Valor Unitário: R$");
			sb.append(item.getProduto().getValor());	
			sb.append("\n");
        }
        sb.append("Valor Total: R$");
        sb.append(pedido.getValor_total());
        sb.append("\n════════════════════════════════════════════════════════════\n\n");
        sb.append("ProjetoX  Rua dos Bobos n° 0 cascavel/PR  Telefone (45)1234-5678");
        
        message2.setFrom(new InternetAddress("emailprojeto123@gmail.com")); //Remetente

        Address[] toUser2 = InternetAddress //Destinatário(s)
                   .parse(cliente.getEmail());  

        message2.setRecipients(Message.RecipientType.TO, toUser2);
        message2.setSubject("Email para o cliente");//Assunto
        message2.setText(sb.toString());
        /**Método para enviar a mensagem criada*/
        Transport.send(message2);
        
	     } catch (MessagingException e) {
	          throw new RuntimeException(e);
	    }
		
	}

	public void enviarParaPrestadora(List<ItemPedido> itens) {
			Pedido pedido = pedidoRepository.findOne(itens.get(0).getPedido().getId_pedido());
			
			Contato cliente = contatoRepository.findOne(pedido.getContato().getId_contato());
			
			Usuario usuario = usuarioRepository.findOne(pedido.getUsuario().getId_usuario());
			
		  try {

			  StringBuilder sb = new StringBuilder();
			  sb.append("Olá, \n");
			  sb.append("Um pedido foi realizado por ");
			  sb.append(usuario.getNome_usuario());
			  sb.append(" para ");
			  sb.append(cliente.getNomeFantasia());
			  sb.append(". \nAqui estão as informações sobrer o orçamento:\n");
		        for (ItemPedido item : itens) {
					sb.append(item.getProduto().getNomeproduto());
					sb.append("   Qtd:");
					sb.append(item.getQuantidade());
					sb.append("\n");
		        }
		        
		  	  //email para a prestadora/empresa
		          Message message = new MimeMessage(session);
		          message.setFrom(new InternetAddress("emailprojeto123@gmail.com")); //Remetente

		          Address[] toUser = InternetAddress //Destinatário(s)
		                     .parse("emailprojeto123@gmail.com");

		          message.setRecipients(Message.RecipientType.TO, toUser);
		          message.setSubject("Email para a prestadora");//Assunto
		          message.setText(sb.toString());
		          /**Método para enviar a mensagem criada*/
		          Transport.send(message);

		     } catch (MessagingException e) {
		          throw new RuntimeException(e);
		    }
	}
	
    

	
}
