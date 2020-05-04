/*
 * ReplyHandlerInterface.java
 *
 * Created on 24 July 2002, 08:53
 */

package net.munki.irc.protocol.rfc2812;

public interface ReplyHandlerInterface {

    // 5.1 Command responses
    
    public void RPL_WELCOME(String reply) throws ReplyHandlerException;    //001";
    public void RPL_YOURHOST(String reply) throws ReplyHandlerException;    //002";
    public void RPL_CREATED(String reply) throws ReplyHandlerException;    //003";
    public void RPL_MYINFO(String reply) throws ReplyHandlerException;    //004";

    public void RPL_BOUNCE(String reply) throws ReplyHandlerException;    //005";

    public void RPL_USERHOST(String reply) throws ReplyHandlerException;    //302";
    
    public void RPL_ISON(String reply) throws ReplyHandlerException;    //303";
    
    public void RPL_AWAY(String reply) throws ReplyHandlerException;    //301";
    public void RPL_UNAWAY(String reply) throws ReplyHandlerException;    //305";
    public void RPL_NOWAWAY(String reply) throws ReplyHandlerException;    //306";
    
    public void RPL_WHOISUSER(String reply) throws ReplyHandlerException;    //311";
    public void RPL_WHOISSERVER(String reply) throws ReplyHandlerException;    //312";
    public void RPL_WHOISOPERATOR(String reply) throws ReplyHandlerException;    //313";
    public void RPL_WHOISIDLE(String reply) throws ReplyHandlerException;    //317";
    public void RPL_ENDOFWHOIS(String reply) throws ReplyHandlerException;    //318";
    public void RPL_WHOISCHANNELS(String reply) throws ReplyHandlerException;    //319";

    public void RPL_WHOWASUSER(String reply) throws ReplyHandlerException;    //314";
    public void RPL_ENDOFWHOWAS(String reply) throws ReplyHandlerException;    //369";

    public void RPL_LISTSTART(String reply) throws ReplyHandlerException;    //321";
    public void RPL_LIST(String reply) throws ReplyHandlerException;    //322";
    public void RPL_LISTEND(String reply) throws ReplyHandlerException;    //323";

    public void RPL_UNIQOPIS(String reply) throws ReplyHandlerException;    //325";
    public void RPL_CHANNELMODEIS(String reply) throws ReplyHandlerException;    //324";
    public void RPL_NOTOPIC(String reply) throws ReplyHandlerException;    //331";
    public void RPL_TOPIC(String reply) throws ReplyHandlerException;    //332";

    public void RPL_INVITING(String reply) throws ReplyHandlerException;    //341";

    public void RPL_SUMMONING(String reply) throws ReplyHandlerException;    //342";

    public void RPL_INVITELIST(String reply) throws ReplyHandlerException;    //346";
    public void RPL_ENDOFINVITELIST(String reply) throws ReplyHandlerException;    //347";

    public void RPL_EXCEPTLIST(String reply) throws ReplyHandlerException;    //348";
    public void RPL_ENDOFEXCEPTLIST(String reply) throws ReplyHandlerException;    //349";

    public void RPL_VERSION(String reply) throws ReplyHandlerException;    //351";

    public void RPL_WHOREPLY(String reply) throws ReplyHandlerException;    //352";
    public void RPL_ENDOFWHO(String reply) throws ReplyHandlerException;    //315";

    public void RPL_NAMREPLY(String reply) throws ReplyHandlerException;    //353";
    public void RPL_ENDOFNAMES(String reply) throws ReplyHandlerException;    //366";

    public void RPL_LINKS(String reply) throws ReplyHandlerException;    //364";
    public void RPL_ENDOFLINKS(String reply) throws ReplyHandlerException;    //365";

    public void RPL_BANLIST(String reply) throws ReplyHandlerException;    //367";
    public void RPL_ENDOFBANLIST(String reply) throws ReplyHandlerException;    //368";

    public void RPL_INFO(String reply) throws ReplyHandlerException;    //371";
    public void RPL_ENDOFINFO(String reply) throws ReplyHandlerException;    //374";

    public void RPL_MOTDSTART(String reply) throws ReplyHandlerException;    //375";
    public void RPL_MOTD(String reply) throws ReplyHandlerException;    //372";
    public void RPL_ENDOFMOTD(String reply) throws ReplyHandlerException;    //"376";

    public void RPL_YOUREOPER(String reply) throws ReplyHandlerException;    //381";

    public void RPL_REHASHING(String reply) throws ReplyHandlerException;    //382";

    public void RPL_YOURESERVICE(String reply) throws ReplyHandlerException;    //383";

    public void RPL_TIME(String reply) throws ReplyHandlerException;    //391";

    public void RPL_USERSSTART(String reply) throws ReplyHandlerException;    //392";
    public void RPL_USERS(String reply) throws ReplyHandlerException;    //393";
    public void RPL_ENDOFUSERS(String reply) throws ReplyHandlerException;    //394";
    public void RPL_NOUSERS(String reply) throws ReplyHandlerException;    //395";

    public void RPL_TRACELINK(String reply) throws ReplyHandlerException;    //200";
    public void RPL_TRACECONNECTING(String reply) throws ReplyHandlerException;    //201";
    public void RPL_TRACEHANDSHAKE(String reply) throws ReplyHandlerException;    //202";
    public void RPL_TRACEUNKNOWN(String reply) throws ReplyHandlerException;    //203";
    public void RPL_TRACEOPERATOR(String reply) throws ReplyHandlerException;    //204";
    public void RPL_TRACEUSER(String reply) throws ReplyHandlerException;    //205";
    public void RPL_TRACESERVER(String reply) throws ReplyHandlerException;    //206";
    public void RPL_TRACESERVICE(String reply) throws ReplyHandlerException;    //207";
    public void RPL_TRACENEWTYPE(String reply) throws ReplyHandlerException;    //208";
    public void RPL_TRACECLASS(String reply) throws ReplyHandlerException;    //209";
    public void RPL_TRACERECONNECT(String reply) throws ReplyHandlerException;    //210";
    public void RPL_TRACELOG(String reply) throws ReplyHandlerException;    //261";
    public void RPL_TRACEEND(String reply) throws ReplyHandlerException;    //262";

    public void RPL_STATSLINKINFO(String reply) throws ReplyHandlerException;    //211";
    public void RPL_STATSCOMMANDS(String reply) throws ReplyHandlerException;    //212";
    public void RPL_ENDOFSTATS(String reply) throws ReplyHandlerException;    //219";
    public void RPL_STATSUPTIME(String reply) throws ReplyHandlerException;    //242";
    public void RPL_STATSOLINE(String reply) throws ReplyHandlerException;    //243";

    public void RPL_UMODEIS(String reply) throws ReplyHandlerException;    //221";

    public void RPL_SERVLIST(String reply) throws ReplyHandlerException;    //= "234";
    public void RPL_SERVLISTEND(String reply) throws ReplyHandlerException;    //235";

    public void RPL_LUSERCLIENT(String reply) throws ReplyHandlerException;    //251";
    public void RPL_LUSEROP(String reply) throws ReplyHandlerException;    //252";
    public void RPL_LUSERUNKNOWN(String reply) throws ReplyHandlerException;    //253";
    public void RPL_LUSERCHANNELS(String reply) throws ReplyHandlerException;    //254";
    public void RPL_LUSERME(String reply) throws ReplyHandlerException;    //255";

    public void RPL_ADMINME(String reply) throws ReplyHandlerException;    //256";
    public void RPL_ADMINLOC1(String reply) throws ReplyHandlerException;    //257";
    public void RPL_ADMINLOC2(String reply) throws ReplyHandlerException;    //258";
    public void RPL_ADMINEMAIL(String reply) throws ReplyHandlerException;    //259";

    public void RPL_TRYAGAIN(String reply) throws ReplyHandlerException;    //263";
    
    // 5.2 Error Replies
    
    public void ERR_NOSUCHNICK(String reply) throws ReplyHandlerException;    //401";
    public void ERR_NOSUCHSERVER(String reply) throws ReplyHandlerException;    //402";
    public void ERR_NOSUCHCHANNEL(String reply) throws ReplyHandlerException;    //403";
    public void ERR_CANNOTSENDTOCHAN(String reply) throws ReplyHandlerException;    //404";
    public void ERR_TOOMANYCHANNELS(String reply) throws ReplyHandlerException;    //405";
    public void ERR_WASNOSUCHNICK(String reply) throws ReplyHandlerException;    //406";
    public void ERR_TOOMANYTARGETS(String reply) throws ReplyHandlerException;    //407";
    public void ERR_NOSUCHSERVICE(String reply) throws ReplyHandlerException;    //408";
    public void ERR_NOORIGIN(String reply) throws ReplyHandlerException;    //409";
    
    public void ERR_NORECIPIENT(String reply) throws ReplyHandlerException;    //411";
    public void ERR_NOTEXTTOSEND(String reply) throws ReplyHandlerException;    //412";
    public void ERR_NOTOPLEVEL(String reply) throws ReplyHandlerException;    //413";
    public void ERR_WILDTOPLEVEL(String reply) throws ReplyHandlerException;    //414";
    public void ERR_BADMASK(String reply) throws ReplyHandlerException;    //415";

    public void ERR_UNKNOWNCOMMAND(String reply) throws ReplyHandlerException;    //421";
    public void ERR_NOMOTD(String reply) throws ReplyHandlerException;    //422";
    public void ERR_NOADMININFO(String reply) throws ReplyHandlerException;    //423";
    public void ERR_FILEERROR(String reply) throws ReplyHandlerException;    //424";

    public void ERR_NONICKNAMEGIVEN(String reply) throws ReplyHandlerException;    //431";
    public void ERR_ERRONEUSNICKNAME(String reply) throws ReplyHandlerException;    //432";
    public void ERR_NICKNAMEINUSE(String reply) throws ReplyHandlerException;    //433";

    public void ERR_NICKCOLLISION(String reply) throws ReplyHandlerException;    //436";
    public void ERR_UNAVAILRESOURCE(String reply) throws ReplyHandlerException;    //437";

    public void ERR_USERNOTINCHANNEL(String reply) throws ReplyHandlerException;    //441";
    public void ERR_NOTONCHANNEL(String reply) throws ReplyHandlerException;    //442";
    public void ERR_USERONCHANNEL(String reply) throws ReplyHandlerException;    //443";
    public void ERR_NOLOGIN(String reply) throws ReplyHandlerException;    //444";
    public void ERR_SUMMONDISABLED(String reply) throws ReplyHandlerException;    //445";
    public void ERR_USERSDISABLED(String reply) throws ReplyHandlerException;    //446";

    public void ERR_NOTREGISTERED(String reply) throws ReplyHandlerException;    //451";

    public void ERR_NEEDMOREPARAMS(String reply) throws ReplyHandlerException;    //461";
    public void ERR_ALREADYREGISTERED(String reply) throws ReplyHandlerException;    //462";
    public void ERR_NOPERMFORHOST(String reply) throws ReplyHandlerException;    //463";
    public void ERR_PASSWDMISMATCH(String reply) throws ReplyHandlerException;    //464";
    public void ERR_YOUREBANNEDCREEP(String reply) throws ReplyHandlerException;    //465";
    public void ERR_YOUWILLBEBANNED(String reply) throws ReplyHandlerException;    //466";
    public void ERR_KEYSET(String reply) throws ReplyHandlerException;    //467";

    public void ERR_CHANNELISFULL(String reply) throws ReplyHandlerException;    //471";
    public void ERR_UNKNOWNMODE(String reply) throws ReplyHandlerException;    //472";
    public void ERR_INVITEONLYCHAN(String reply) throws ReplyHandlerException;    //473";
    public void ERR_BANNEDFROMCHAN(String reply) throws ReplyHandlerException;    //474";
    public void ERR_BADCHANNELKEY(String reply) throws ReplyHandlerException;    //475";
    public void ERR_BADCHANMASK(String reply) throws ReplyHandlerException;    //476";
    public void ERR_NOCHANMODES(String reply) throws ReplyHandlerException;    //477";
    public void ERR_BANLISTFULL(String reply) throws ReplyHandlerException;    //478";

    public void ERR_NOPRIVILEGES(String reply) throws ReplyHandlerException;    //481";
    public void ERR_CHANOPRIVSNEEDED(String reply) throws ReplyHandlerException;    //482";
    public void ERR_CANTKILLSERVER(String reply) throws ReplyHandlerException;    //483";
    public void ERR_RESTRICTED(String reply) throws ReplyHandlerException;    //484";
    public void ERR_UNIQOPPRIVSNEEDED(String reply) throws ReplyHandlerException;    //485";

    public void ERR_NOOPERHOST(String reply) throws ReplyHandlerException;    //491";

    public void ERR_UMODEUNKNOWNFLAG(String reply) throws ReplyHandlerException;    //501";
    public void ERR_USERSDONTMATCH(String reply) throws ReplyHandlerException;    //502";
    
    // 5.3 Reserved numerics
    
    public void RPL_SERVICEINFO(String reply) throws ReplyHandlerException;    //231";
    public void RPL_ENDOFSERVICES(String reply) throws ReplyHandlerException;    //232";
    public void RPL_SERVICE(String reply) throws ReplyHandlerException;    //233";

    public void RPL_NONE(String reply) throws ReplyHandlerException;    //300";

    public void RPL_WHOISCHANOP(String reply) throws ReplyHandlerException;    //316";

    public void RPL_KILLDONE(String reply) throws ReplyHandlerException;    //361";
    public void RPL_CLOSING(String reply) throws ReplyHandlerException;    //362";
    public void RPL_CLOSEEND(String reply) throws ReplyHandlerException;    //363";

    public void RPL_INFOSTART(String reply) throws ReplyHandlerException;    //373";

    public void RPL_MYPORTIS(String reply) throws ReplyHandlerException;    //384";

    public void RPL_STATSCLINE(String reply) throws ReplyHandlerException;    //213";
    public void RPL_STATSNLINE(String reply) throws ReplyHandlerException;    //214";
    public void RPL_STATSILINE(String reply) throws ReplyHandlerException;    //215";
    public void RPL_STATSKLINE(String reply) throws ReplyHandlerException;    //216";
    public void RPL_STATSQLINE(String reply) throws ReplyHandlerException;    //217";
    public void RPL_STATSYLINE(String reply) throws ReplyHandlerException;    //218";

    public void RPL_STATSVLINE(String reply) throws ReplyHandlerException;    //240";
    public void RPL_STATSLLINE(String reply) throws ReplyHandlerException;    //241";

    public void RPL_STATSHLINE(String reply) throws ReplyHandlerException;    //244";
    public void RPL_STATSSLINE(String reply) throws ReplyHandlerException;    //245";
    public void RPL_STATSPING(String reply) throws ReplyHandlerException;    //246";
    public void RPL_STATSBLINE(String reply) throws ReplyHandlerException;    //247";

    public void RPL_STATSDLINE(String reply) throws ReplyHandlerException;    //250";
}

