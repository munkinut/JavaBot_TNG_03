/*
 * IRCMessageInterface.java
 *
 * Created on 23 July 2002, 14:56
 */

package net.munki.irc.handlers.reply;

import net.munki.irc.protocol.rfc2812.ReplyHandlerException;
import net.munki.irc.protocol.rfc2812.ReplyHandlerInterface;

/** A definition of IRC numeric reply messages. */
public interface IRCReplyInterface extends ReplyHandlerInterface {

    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_NICKCOLLISION(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_NOSUCHNICK(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_WHOISOPERATOR(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_ENDOFBANLIST(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_MYPORTIS(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_STATSDLINE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_KILLDONE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_UNAVAILRESOURCE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_LUSERCHANNELS(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_STATSYLINE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_NOWAWAY(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_NEEDMOREPARAMS(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_NOCHANMODES(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_WILDTOPLEVEL(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_TOOMANYTARGETS(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_STATSLINKINFO(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_INVITEONLYCHAN(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_LIST(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_STATSOLINE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_CLOSEEND(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_REHASHING(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_ISON(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_NOTOPIC(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_NOORIGIN(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_ENDOFINFO(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_BANLIST(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_WHOISIDLE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_STATSPING(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_STATSVLINE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_NONICKNAMEGIVEN(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_INFO(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_WELCOME(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_ENDOFUSERS(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_ENDOFSTATS(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_PASSWDMISMATCH(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_STATSUPTIME(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_INVITING(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_NOSUCHCHANNEL(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_TOOMANYCHANNELS(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_NOLOGIN(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_RESTRICTED(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_BANNEDFROMCHAN(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_UNKNOWNMODE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_USERSSTART(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_NOTREGISTERED(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_FILEERROR(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_SERVLISTEND(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_ENDOFMOTD(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_USERNOTINCHANNEL(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_SUMMONING(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_ENDOFSERVICES(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_WASNOSUCHNICK(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_USERHOST(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_CHANOPRIVSNEEDED(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_YOURHOST(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_CANTKILLSERVER(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_KEYSET(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_SUMMONDISABLED(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_UNIQOPPRIVSNEEDED(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_ERRONEUSNICKNAME(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_NAMREPLY(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_NOUSERS(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_UMODEIS(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_WHOISCHANOP(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_LUSEROP(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_SERVICE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_UMODEUNKNOWNFLAG(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_LINKS(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_NOOPERHOST(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_STATSQLINE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_TRACEEND(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_NOTOPLEVEL(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_LUSERCLIENT(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_LUSERUNKNOWN(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_ADMINLOC2(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_STATSCLINE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_ENDOFINVITELIST(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_ENDOFLINKS(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_NOADMININFO(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_YOURESERVICE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_ENDOFWHO(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_NORECIPIENT(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_ADMINLOC1(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_BADCHANNELKEY(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_BADMASK(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_ENDOFWHOIS(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_SERVICEINFO(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_TRACELINK(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_NOSUCHSERVICE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_LISTEND(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_INFOSTART(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_STATSNLINE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_ENDOFEXCEPTLIST(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_STATSKLINE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_BANLISTFULL(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_MOTDSTART(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_TRACECONNECTING(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_MYINFO(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_USERSDISABLED(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_ENDOFWHOWAS(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_YOUREBANNEDCREEP(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_MOTD(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_STATSHLINE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_CLOSING(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_NICKNAMEINUSE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_TOPIC(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_ALREADYREGISTERED(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_STATSSLINE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_STATSLLINE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_NOTEXTTOSEND(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_TRACEOPERATOR(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_BADCHANMASK(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_CHANNELMODEIS(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_INVITELIST(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_UNIQOPIS(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_CHANNELISFULL(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_CANNOTSENDTOCHAN(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_STATSBLINE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_WHOISCHANNELS(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_STATSCOMMANDS(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_NONE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_NOPRIVILEGES(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_BOUNCE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_YOUWILLBEBANNED(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_ENDOFNAMES(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_TRACELOG(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_NOTONCHANNEL(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_NOMOTD(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_TRACESERVICE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_NOSUCHSERVER(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_USERONCHANNEL(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_TRACECLASS(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_UNKNOWNCOMMAND(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_TIME(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_TRACEHANDSHAKE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_TRACESERVER(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_STATSILINE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_SERVLIST(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_TRACENEWTYPE(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_WHOWASUSER(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_WHOREPLY(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_NOPERMFORHOST(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_VERSION(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_USERS(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_LUSERME(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_UNAWAY(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_TRACERECONNECT(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_TRACEUNKNOWN(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_LISTSTART(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void ERR_USERSDONTMATCH(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_EXCEPTLIST(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_YOUREOPER(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_TRACEUSER(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_WHOISUSER(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_WHOISSERVER(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_ADMINEMAIL(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_TRYAGAIN(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_ADMINME(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_CREATED(String reply) throws ReplyHandlerException;
    
    /**
     * @param reply
     * @throws ReplyHandlerException
     */
    void RPL_AWAY(String reply) throws ReplyHandlerException;
    
}

